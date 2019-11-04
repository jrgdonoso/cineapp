package pruebaRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo= contex.getBean("peliculasRepository",PeliculasRepository.class);
		
		List<Pelicula> it=repo.findAll();
		
		System.out.println("Lista de peliculas: ");
		for(  Pelicula p:it ) {
			System.out.println(p.getDetalle());
		}
		
		
		
		
		contex.close();

	}

}
