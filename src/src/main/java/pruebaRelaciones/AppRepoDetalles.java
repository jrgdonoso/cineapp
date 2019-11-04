package pruebaRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetalleRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		DetalleRepository repo= contex.getBean("detalleRepository",DetalleRepository.class);
		
		List<Detalle> it=repo.findAll();
		for(  Detalle d:it ) {
			System.out.println(d.toString());
		}
		
		
		
		
		contex.close();
		
		
		

	}

}
