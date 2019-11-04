package appQuery;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeyWordFinfBy {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		List<Noticia> it=null;
		//Iterable<Noticia> it=repo.findByEstatus("inactiva"); ///Busca por estatus		
		
		try {
			// it=repo.findByFecha(df.parse("2017-09-01"));//Busca por fehca
			it=repo.findByEstatusAndFecha("Inactiva", df.parse("2017-09-01"));
		}catch(Exception e) {
			System.out.println("ERROR");
		}
		
		System.out.println("Noticias encontradas:");
		for(  Noticia n:it ) {
			System.out.println("----------Noticias "+n.getTitulo());
		}
		
		contex.close();
		

	}

}
