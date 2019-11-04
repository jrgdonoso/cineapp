package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;


@Service
public class HorarioServiceJPA implements IHorarioService{
	
	
	@Autowired
	HorariosRepository horaRepo;

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		String fechaF=new SimpleDateFormat("yyyy-MM-dd").format(fecha);
		System.out.println("fecha busqueda " + fechaF+" - id pelicula - "+idPelicula);
		return horaRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

}
