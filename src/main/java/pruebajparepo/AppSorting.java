package pruebajparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Se cambia Iterable por List, ejemplo con orden con un campo
		List<Noticia> it=repo.findAll(Sort.by("titulo").ascending());
		
		//Ordenar por dos campos
		List<Noticia> it2=repo.findAll(Sort.by("fecha").ascending().and(Sort.by("titulo").ascending()));
		
		
		
		for(  Noticia n:it2 ) {
			System.out.println(n.getId()+"-"+n.getTitulo()+"-"+n.getDetalle());
		}
		
		
		
		
		contex.close();



	}

}
