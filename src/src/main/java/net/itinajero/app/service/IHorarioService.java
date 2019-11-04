package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Horario;

public interface IHorarioService {

	List<Horario> buscarPorIdPelicula(int idPelicula, Date fechaBusqueda);
}
