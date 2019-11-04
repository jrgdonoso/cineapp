package pruebaRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.DetalleRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class AppGetHorarioPeliculas {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo= contex.getBean("peliculasRepository",PeliculasRepository.class);
		
		List<Pelicula> it=repo.findAll();
		for(  Pelicula d:it ) {
			System.out.println(d.toString());
		}
		
		
		
		
		contex.close();

	}

}
