package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
				NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
				
				int idNoticiaBusqueda=20;
				Boolean existeNoticia=repo.existsById(idNoticiaBusqueda);//Consulta si existe la noticia con ID '2'
				System.out.println("¿Existe noticia con ID  "+idNoticiaBusqueda+"?: "+existeNoticia);
				
				contex.close();

	}

}
