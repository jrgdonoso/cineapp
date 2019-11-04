package net.itinajero.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IDetalleService;
import net.itinajero.app.service.PeliculasServiceImpl;
import net.itinajero.app.service.PeliculasServiceJPA;
import util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	
	@Autowired
	private IDetalleService detalleServicio;
	
	
	@Autowired
    private PeliculasServiceJPA ServicePelicula;
	//private PeliculasServiceImpl ServicePelicula;
	
	

	//@ModelAttribute permite hacer el vinculo con nuestro formulario HTML
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {

		//model.addAttribute("listaGenero", ServicePelicula.buscaGenero());
		return "peliculas/formPeliculas";
	}

	@GetMapping("/indexnormal")
	public String mostrarIndex(Model model) {

		List<Pelicula> lista = ServicePelicula.buscarTodas();

		model.addAttribute("peliculas", lista);
		return "peliculas/listaPeliculas";

	}
	
	
	//Para la paginacion
	@GetMapping(value="/index")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	
		Page<Pelicula> listaP=ServicePelicula.buscarTodas(page);
		model.addAttribute("peliculas",listaP);
		return "peliculas/listaPeliculas";
	}
	
	
	

	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributs,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) { // bindingResult los errores no se muestran en el
		// navegador,guarda errores en el proceso de
		// dataBinding

		if (result.hasErrors()) {
			System.out.println("Existieron errores al guardar pelicula");
			int i = 1;
			for (ObjectError error : result.getAllErrors()) {

				System.out.println(i + "." + error.getDefaultMessage());
				i++;
			}
			return "peliculas/formPeliculas";
		}

		// Guarda archivo en servidor
		if(!multiPart.isEmpty()) {
		 String nombreImagen=Utileria.guardarImagen( multiPart, request);
		 nombreImagen=nombreImagen.replace(" ", "-");
		 
		 System.out.println("nombre imagen "+nombreImagen);
		 pelicula.setImagen(nombreImagen);
		 }

		// model.addAttribute("mensaje", "Registro guardado correctamente");
		attributs.addFlashAttribute("mensaje", "Registro guardado correctamente");// Con RedirectAttributes permite
																					// enviar mensajes hacia el redirect

		//Insertar detalle
		System.out.println("Guardando objeto detalle "+pelicula.getDetalle());
		detalleServicio.insertar(pelicula.getDetalle());
		
		System.out.println("Guardando objeto pelicula " + pelicula.toString());
		ServicePelicula.insertar(pelicula);
		System.out.println("cantidad peliculas total " + ServicePelicula.buscarTodas().size());
		// return "peliculas/formPeliculas";
		return "redirect:/peliculas/index";
	}
	
	
	
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model ) {
		
		Pelicula miPelicula=ServicePelicula.buscarPorId(idPelicula);
	   model.addAttribute("pelicula", miPelicula);  
	   
	  // model.addAttribute("listaGenero", ServicePelicula.buscaGenero());//reemplazado por getGeneros()
	  
		return "peliculas/formPeliculas";
	}
	
	
	
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") int idPelicula, Model model,Pageable page ) {
		
		
		
		
		//*Tambien es posible traer el id del detalle desde el jsp
		//Busco el id detalle segun el id de pelicula
		Pelicula miPeli=ServicePelicula.buscarPorId(idPelicula);
		
		ServicePelicula.delete(idPelicula);//Elimino pelicula
		if( miPeli.getDetalle()!= null ) { //elimino detalle
			System.out.println("Detalle a eliminar "+miPeli.getDetalle().getId());
		detalleServicio.delete(miPeli.getDetalle().getId());
		}
		
		
		model.addAttribute("peliculas", ServicePelicula.buscarTodas());
		
		Page<Pelicula> listaP=ServicePelicula.buscarTodas(page);
		model.addAttribute("peliculas",listaP);
		
		//Tambien se podria redireccionar
		return "peliculas/listaPeliculas";
	}
	
	
	
	
	
	//Con este metodo obtenemos los generos cada vez que llamemos al modelo desde este controlador
	//De esta forma no es necesario llenar los generos en cada metodo del controlador
	@ModelAttribute("listaGenero")
	public List<String> getGeneros(){
		
		return ServicePelicula.buscaGenero();
		
	}
	
	

	@InitBinder
	public void InitBinder(WebDataBinder binder) { // La configuracion del dataBinder es por controllador
		SimpleDateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatear, false)); // (El ultimo "false" es para
																							// no permitir valores null)
	}

	

}
