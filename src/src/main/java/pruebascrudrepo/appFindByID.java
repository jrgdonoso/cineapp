package pruebascrudrepo;

import java.awt.List;
import java.util.LinkedList;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appFindByID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Buscar por un ID
		int idBuscar=1;
		
		Optional<Noticia> opt= repo.findById(idBuscar);
		System.out.println("Noticias por ID");
		System.out.println("Noticia encontrada buscada por un ID "+opt.get().getId() + opt.get().getTitulo() );
		
		//Buscar por varios ID
		LinkedList<Integer> ids= new LinkedList<Integer>();
		ids.add(1);
		ids.add(3);
		
		Iterable<Noticia> lista=repo.findAllById(ids);
		
		System.out.println("Lista noticias:");
		for(  Noticia n:lista ) {
			System.out.println(n.getId()+"-"+n.getTitulo()+"-"+n.getDetalle());
		}

	}

}
