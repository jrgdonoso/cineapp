package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		//La clase Optiona esta disponible desde java8
		Optional<Noticia> noticia=repo.findById(1);
		System.out.println("Noticia:");
		System.out.println(noticia);
		System.out.println("Titulo -> "+noticia.get().getTitulo());
		
		contex.close();

	}

}
