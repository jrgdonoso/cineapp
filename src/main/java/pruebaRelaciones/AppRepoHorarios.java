package pruebaRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		HorariosRepository repo= contex.getBean("horariosRepository",HorariosRepository.class);
		
		List<Horario> it=repo.findAll();
		for(  Horario d:it ) {
			System.out.println(d.getPelicula());
		}
		
		
		
		
		contex.close();
		

	}

}
