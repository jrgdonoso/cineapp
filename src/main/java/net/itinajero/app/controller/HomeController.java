package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.BannersServiceImpl;
import net.itinajero.app.service.IHorarioService;
import net.itinajero.app.service.IPeliculaService;
import net.itinajero.app.service.NoticiaServiceImpl;
import net.itinajero.app.service.PeliculasServiceImpl;
import util.Utileria;

@Controller
public class HomeController {


	
	@Autowired
	private BannersServiceImpl serviceBanners;
	
	
	
	
	@Autowired
	private IPeliculaService servicePeliculaJPA;
	
	
	
	
	@Autowired
	private IHorarioService serviHorario;
	
	
	@RequestMapping(value = "/test" )
	public String test() {
	return "test";
	}
	
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	// Busca pelicula segun fecha,sera a peticiones tipo POST ya que se enviara
	// desde un form
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscar( Model model,@RequestParam("fecha") String fecha) {

		//Buscar con base de datos
		System.out.println("Fecha buscada " + fecha);
		
		// Para las fechas del select
		List<String> listaFechas = Utileria.getNextDays(4);
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

		//List<Pelicula> peliculas = getListaPeliculas();//Obtiene lista de peliculas desde metodo local
		//List<Pelicula> peliculas=servicePeliculas.buscarTodas();
		List<Pelicula> peliculas=servicePeliculaJPA.buscarTodas();
		model.addAttribute("peliculas", peliculas);
	    model.addAttribute("fechaBusqueda", fecha);
		
		model.addAttribute("fechas", listaFechas);
		
		
		return "home";
	}
	
	
	
	
	
	@RequestMapping(value = "/formLogin" )
	public String mostrarLogin() {
	return "formLogin";
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		// Para las fechas del select
		List<String> listaFechas = Utileria.getNextDays(4);
		// System.out.println("Fechas "+ listaFechas);

		SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

		/*List<Pelicula> peliculas = getListaPeliculas();*/
		List<Pelicula> peliculas =servicePeliculaJPA.buscarTodas();
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", formatofecha.format(new Date()));
		model.addAttribute("fechas", listaFechas);
		
		
		model.addAttribute("banners", serviceBanners.buscarTodos());
		

		/*
		 * List<String> peliculas= new LinkedList<>();
		 * 
		 * peliculas.add("martes 13"); peliculas.add("Rapido y furioso");
		 * peliculas.add("Los simpsons");
		 * 
		 * model.addAttribute("peliculas", peliculas);
		 */

		// return "homeRespaldo";
		return "home";
	}

	/*
	 * @RequestMapping(value = "/detail/{id}/{fecha_busqueda}",
	 * method=RequestMethod.GET) public String mostrarDetalle_old(Model
	 * model, @PathVariable("id") int idPelicula, @PathVariable("fecha_busqueda")
	 * String fechaBusqueda) {//Mapeo el valor de la variable id enviada por URL
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") Date fechaBusqueda) {// Mapeo con el metodo @RequestParam

		System.out.println("Valoir del ID " + idPelicula);
		System.out.println("Valoir de la fecha " + fechaBusqueda);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");

		// Buscar en la DB los horarios de la pelicula
		//Para transformar de String a date
		//dFechaBusqueda=new SimpleDateFormat("yyyy-MM-dd").parse(fechaBusqueda);
		List<Horario> horarios=serviHorario.buscarPorIdPelicula(idPelicula, fechaBusqueda);
		
		System.out.println("lista horarios: "+horarios.toString());

		String titulopelicula = "El transportador";
		int duracion = 90;
		int precioEntrada = 2000;

		model.addAttribute("titulo", titulopelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		model.addAttribute("pelicula", servicePeliculaJPA.buscarPorId(idPelicula));
		model.addAttribute("horarios",  horarios);
		model.addAttribute("fechaBuscada",  sf.format(fechaBusqueda));

		/* Se retorna elnombre dela vista */
		return "detalle";
	}

	
	
	//Para al momento de hacer el binder entre los datos del formulario y variables se realice un formateo
	//en el load
	@InitBinder
	public void InitBinder(WebDataBinder binder) { // La configuracion del dataBinder es por controllador
		SimpleDateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatear, false)); // (El ultimo "false" es para
																							// no permitir valores null)
	}
	
	
	
	private List<Pelicula> getListaPeliculas() {
		SimpleDateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;

		try {

			lista = new LinkedList<>();

			Pelicula peli = new Pelicula();
			peli.setId(1);
			peli.setTitulo("rapido y furioso");
			peli.setDuracion(90);
			peli.setEstatus("Activa");
			peli.setClasificacion("Clasificacion ");
			peli.setGenero("Genero ");
			peli.setFechaEstreno(formatear.parse("01-05-2015"));
			peli.setImagen("estreno1.png");

			Pelicula peli1 = new Pelicula();
			peli1.setId(2);
			peli1.setTitulo("Los Simpsons");
			peli1.setDuracion(95);
			peli1.setEstatus("Activa");
			peli1.setClasificacion("Clasificacion 1");
			peli1.setGenero("Genero 1");
			peli1.setFechaEstreno(formatear.parse("01-05-2004"));
			peli1.setImagen("estreno2.png");

			Pelicula peli2 = new Pelicula();
			peli2.setId(3);
			peli2.setTitulo("Guerra de papas");
			peli2.setDuracion(80);
			peli2.setEstatus("Activa");
			peli2.setClasificacion("Clasificacion 2");
			peli2.setGenero("Genero 2");
			peli2.setFechaEstreno(formatear.parse("01-05-2016"));
			peli2.setImagen("estreno3.png");

			Pelicula peli3 = new Pelicula();
			peli3.setId(4);
			peli3.setTitulo("Guerra de papas");
			peli3.setDuracion(80);
			peli3.setEstatus("Activa");
			peli3.setClasificacion("Clasificacion 3");
			peli3.setGenero("Genero 3");
			peli3.setFechaEstreno(formatear.parse("01-05-2016"));
			peli3.setImagen("estreno4.png");

			Pelicula peli4 = new Pelicula();
			peli4.setId(5);
			peli4.setTitulo("Estreno 5");
			peli4.setDuracion(58);
			peli4.setEstatus("Activa");
			peli4.setClasificacion("Clasificacion 4");
			peli4.setGenero("Genero 4");
			peli4.setFechaEstreno(formatear.parse("01-05-2016"));
			peli4.setImagen("estreno5.png");

			lista.add(peli);
			lista.add(peli1);
			lista.add(peli2);
			lista.add(peli3);
			lista.add(peli4);

		} catch (ParseException e) {

			System.out.println("Error : " + e.getMessage());
			return null;
		}

		return lista;

	}

}
