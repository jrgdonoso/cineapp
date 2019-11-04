package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appConexion {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext contex=new ClassPathXmlApplicationContext("root-context.xml"); 
		
		contex.close();

	}

}
