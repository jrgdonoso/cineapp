package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.DetalleRepository;
import net.itinajero.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculaService{
	
	@Autowired
	private PeliculasRepository peliRepo;
	
	
	
	
	@Override
	public List<Pelicula> buscarTodas() {
		return peliRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		Optional<Pelicula> opt= peliRepo.findById(idPelicula);
		
		//Enviara el objeto siempre y cuando haya encontrado datos
		if( opt.isPresent() ) {
		  return opt.get();
		}
		
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		peliRepo.save(pelicula);		
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
		peliRepo.deleteById(iPelicula);
		
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return peliRepo.findAll(page);
	}

}
