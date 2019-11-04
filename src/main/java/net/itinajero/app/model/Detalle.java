package net.itinajero.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalle {
	private int id;
	private String director;
	private String actores;
	private String sinopsis;
	private String trailer;

	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementable
	public int getId() {
		return id;
	}
	
	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailler) {
		this.trailer = trailler;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	

	public void setId(int id) {
		this.id = id;
	}
	

}
