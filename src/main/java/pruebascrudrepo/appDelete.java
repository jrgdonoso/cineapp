package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class appDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= contex.getBean("noticiasRepository",NoticiasRepository.class);
		
		int idNoticiaDElete=2;
		Boolean existeNoticia=repo.existsById(idNoticiaDElete);//Consulta si existe la noticia con ID
		if(existeNoticia) {
			repo.deleteById(idNoticiaDElete);
			System.out.println("Noticia con ID  "+existeNoticia+" eliminada");
		}else {
			System.out.println("No existe noticia con ID "+idNoticiaDElete);
		}
		
		
		
		
		contex.close();

	}

}
