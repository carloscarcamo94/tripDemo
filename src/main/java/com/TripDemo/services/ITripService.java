package com.TripDemo.services;

import java.util.List;

import com.TripDemo.model.Trip;

public interface ITripService {

	//Método para buscar todos los trips
	public List<Trip> buscarTodos();
	public Trip buscarPorId(Integer idTrip);
	void guardar(Trip trip);
	void eliminar(Integer idTrip);
	
	List<Trip> buscarPorDescripcion(String descripcion);
	List<Trip> buscarPorCategoria(Integer idCategoria);
}
