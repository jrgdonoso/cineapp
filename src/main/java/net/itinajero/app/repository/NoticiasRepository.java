package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {  ///Para las pruebas del paquete pruebascrudrepo
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	
	//Select * from Noticia
	List<Noticia> findBy();
	
	
	//select * from Noticia where estatus=?
	List<Noticia> findByEstatus(String status);
	
	
	//select * from Noticia where fecha=?
    List<Noticia> findByFecha(Date fecha);
    
    List<Noticia> findByEstatusAndFecha(String estatus,Date fecha);//Tambien funciona con 'OR'

}
