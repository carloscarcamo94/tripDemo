package com.TripDemo.model;

import java.util.Date;

public class Trip{
	
	private Integer id;
	private String nomTrip;
	private String descripcion;
	private Double costo;
	private int calificacion;
	private String imagen;
	private String detalles;
	private boolean activo;
	private Date fecha;

	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomTrip() {
		return nomTrip;
	}
	public void setNomTrip(String nomTrip) {
		this.nomTrip = nomTrip;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	
	@Override
	public String toString() {
		return "Trip [id=" + id + ", nomTrip=" + nomTrip + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", costo=" + costo + ", calificacion=" + calificacion + "]";
	}

	
}