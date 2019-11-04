package net.itinajero.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class loginController {



	@GetMapping(value = "/index")
	public String mostrarPrincipalAdmin(Authentication autentication) {
		
		//imprimir nombre
		System.out.println("Usuario autentication: "+autentication.getName());
		//imprimir roles
		for( GrantedAuthority rol:autentication.getAuthorities() ) {
			System.out.println("roles autentication: "+rol.getAuthority());
		}
		
		return "admin";
		}

	
	
	
	
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/formLogin";
	}
	
	
	


}
