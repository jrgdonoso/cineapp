package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> buscarTodas();
	
	Pelicula buscarPorId(int idPelicula);
	
	void insertar(Pelicula pelicula);
	
	List<String> buscaGenero();
	
	void delete(int iPelicula);
	
	Page<Pelicula> buscarTodas(Pageable page); 
}


