package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetalleRepository;

@Service
public class DetallesServiceJPA implements IDetalleService {
	
	@Autowired
	private DetalleRepository detalleRepo;

	@Override
	public void insertar(Detalle detalle) {
		// TODO Auto-generated method stub
		detalleRepo.save(detalle);
		
	}

	@Override
	public void delete(int idDetalle) {
		detalleRepo.deleteById(idDetalle);
	}
	
	
	
	
	
	

}
