package pruebascrudrepo;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Se cambia Iterable por List
		List<Noticia> it=repo.findAll();
		for(  Noticia n:it ) {
			System.out.println(n.getId()+"-"+n.getTitulo()+"-"+n.getDetalle());
		}
		
		
		
		
		contex.close();


	}

}
