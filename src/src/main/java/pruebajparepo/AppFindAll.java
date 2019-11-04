package pruebajparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		Iterable<Noticia> it=repo.findAll();
		for(  Noticia n:it ) {
			System.out.println(n.getId()+"-"+n.getTitulo()+"-"+n.getDetalle());
		}
		
		
		
		
		contex.close();

	}

}
