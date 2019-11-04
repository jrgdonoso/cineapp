package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Pelicula;

///@Service
public class PeliculasServiceImpl implements IPeliculaService {

	private List<Pelicula> lista = null;
	
	
	public PeliculasServiceImpl() {
		
		System.out.println("Creando intancia de la clase peliculas service...");
		
		SimpleDateFormat formatear = new SimpleDateFormat("dd-mm-yyyy");
		

		try {
			
			this.lista=new LinkedList<>();
			
			Pelicula peli = new Pelicula();
			Detalle detalle=new Detalle();			
			detalle.setDirector("Director");			
			peli.setId(1);
			peli.setTitulo("rapido y furioso");
			peli.setDuracion(90);
			peli.setEstatus("Activa");
			peli.setClasificacion("Clasificacion ");
			peli.setGenero("Genero ");
			peli.setFechaEstreno(formatear.parse("01-05-2015"));
			peli.setImagen("estreno1.png");
			peli.setDetalle(detalle);
			

			Pelicula peli1 = new Pelicula();
			Detalle detalle1=new Detalle();			
			detalle1.setDirector("Director 1");
			peli1.setId(2);
			peli1.setTitulo("Los Simpsons");
			peli1.setDuracion(95);
			peli1.setEstatus("Activa");
			peli1.setClasificacion("Clasificacion 1");
			peli1.setGenero("Genero 1");
			peli1.setFechaEstreno(formatear.parse("01-05-2004"));
			peli1.setImagen("estreno2.png");
			peli1.setDetalle(detalle1);

			
			
			Pelicula peli2 = new Pelicula();
			Detalle detalle2=new Detalle();			
			detalle2.setDirector("Director 2");
			peli2.setId(3);
			peli2.setTitulo("Guerra de papas");
			peli2.setDuracion(80);
			peli2.setEstatus("Activa");
			peli2.setClasificacion("Clasificacion 2");
			peli2.setGenero("Genero 2");
			peli2.setFechaEstreno(formatear.parse("01-05-2016"));
			peli2.setImagen("estreno3.png");
			peli2.setDetalle(detalle2);

			
			
			
			Pelicula peli3 = new Pelicula();
			Detalle detalle3=new Detalle();			
			detalle3.setDirector("Director 3");
			peli3.setId(4);
			peli3.setTitulo("Guerra de papas");
			peli3.setDuracion(80);
			peli3.setEstatus("Activa");
			peli3.setClasificacion("Clasificacion 3");
			peli3.setGenero("Genero 3");
			peli3.setFechaEstreno(formatear.parse("01-05-2016"));
			peli3.setImagen("estreno4.png");
			peli3.setDetalle(detalle3);

			
			
			
			
			Pelicula peli4 = new Pelicula();
			Detalle detalle4=new Detalle();			
			detalle4.setDirector("Director 4");
			peli4.setId(5);
			peli4.setTitulo("Estreno 5");
			peli4.setDuracion(58);
			peli4.setEstatus("Activa");
			peli4.setClasificacion("Clasificacion 4");
			peli4.setGenero("Genero 4");
			peli4.setFechaEstreno(formatear.parse("01-05-2016"));
			peli4.setImagen("estreno5.png");
			peli4.setDetalle(detalle4);

			this.lista.add(peli);
			this.lista.add(peli1);
			this.lista.add(peli2);
			this.lista.add(peli3);
			this.lista.add(peli4);

		} catch (ParseException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	
	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return this.lista;
	}


	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for(Pelicula p: this.lista) {
			if(p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}


	@Override
	public void insertar(Pelicula pelicula) {
		this.lista.add(pelicula);
		
	}


	@Override
	public List<String> buscaGenero() {


		List<String> listaGenero=new LinkedList<>();
		
		
		listaGenero.add("Accion");
		listaGenero.add("Aventura");
		listaGenero.add("Clasicas");
		listaGenero.add("Comedia romantica");
		listaGenero.add("Drama");
		listaGenero.add("Terror");
		listaGenero.add("Infantil");
		listaGenero.add("Accion y aventura");
		listaGenero.add("Romantica");
		
		return listaGenero;
	}


	@Override
	public void delete(int iPelicula) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
