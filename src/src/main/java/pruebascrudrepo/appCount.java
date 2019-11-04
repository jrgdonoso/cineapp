package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
				NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
				
				//La clase Optiona esta disponible desde java8
				
				System.out.println("Existen "+repo.count()+" noticias");
				
				contex.close();
		
		
		
		

	}

}
