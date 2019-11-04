package pruebajparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		///Obtiene lista paginada
		///Iterable<Noticia> it=repo.findAll(PageRequest.of(0, 5));
		
		///Obtiene lista ordenada y paginada
		Iterable<Noticia> it=repo.findAll(PageRequest.of(0, 5, Sort.by("titulo")));
		
		for(  Noticia n:it ) {
			System.out.println(n.getId()+"-"+n.getTitulo()+"-"+n.getDetalle());
		}
		
		
		
		
		contex.close();

	}

}
