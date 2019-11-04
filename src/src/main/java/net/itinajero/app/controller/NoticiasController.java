package net.itinajero.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.NoticiaServiceImpl;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	
	@Autowired
	private NoticiaServiceImpl serviceNoticias;
	
	

	@GetMapping(value = "/create")
	public String crear() {

		return "noticias/formNoticia";
	}

	/*@PostMapping(value = "/save")
	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String status,
			@RequestParam("detalle") String detalle) {
*/
	@PostMapping(value = "/save")
	public String guardar(Noticia noticia) { //Con DataBinding el objeto se llena de forma automatica con los campos del formulario, siempre y cuando se llamen igual
		
		/*Noticia noticia=new Noticia();
		noticia.setTitulo(titulo);
		noticia.setDetalle(detalle);
		noticia.setStatus(status);
		noticia.setId(0);*/

		System.out.println("Titulo " + noticia.getTitulo() + ", status " + noticia.getEstatus() + ", detalle=" + noticia.getDetalle());
		
		
		serviceNoticias.guardar(noticia);
		
		
		return "noticias/formNoticia";

	}

}
