package net.itinajero.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="noticias")



public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String detalle;
	private String estatus;
	private Date fecha;
	
	
	
	public Noticia()
	{
		this.fecha=new Date();
		this.estatus="activa";
	}
	
	
	
	
	public Noticia(int id, String titulo, String detalle, String status, Date fecha) {
	
		this.id = id;
		this.titulo = titulo;
		this.detalle = detalle;
		this.estatus = status;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String status) {
		this.estatus = status;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", detalle=" + detalle + ", estatus=" + estatus + ", fecha="
				+ fecha + "]";
	} 
	
	
	

}
