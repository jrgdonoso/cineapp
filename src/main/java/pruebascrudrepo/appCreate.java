package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;


public class appCreate {

	public static void main(String[] args) {
		
		
		Noticia noticia=new Noticia();		
		noticia.setTitulo("Titulo Noticia");
		noticia.setDetalle("Ago de texto que representa el detalle de la noticia...");
		
		
		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository", NoticiasRepository.class); 
		
		repo.save(noticia);

		contex.close();
	}

}
