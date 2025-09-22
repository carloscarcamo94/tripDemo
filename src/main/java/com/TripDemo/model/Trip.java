package com.TripDemo.model;

import java.util.Date;

public class Trip{
	
	private Integer id;
	private String nomTrip;
	private String descripcion;
	private Date fecha;
	private Double costo;
	private String direccion;
	private int calificacion;
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
				+ ", costo=" + costo + ", direccion=" + direccion + ", calificacion=" + calificacion + "]";
	}

	
}