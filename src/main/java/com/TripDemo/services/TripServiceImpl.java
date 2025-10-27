package com.TripDemo.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TripDemo.model.Trip;


@Service
public class TripServiceImpl implements ITripService {

	
	List<Trip> lista = null;
	
	@Override
	public List<Trip> buscarTodos() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		lista = new LinkedList<>();
			
			try {
				Trip trip1 = new Trip();
				trip1.setId(1);
				trip1.setNomTrip("Rapel en Volcatenango");
				trip1.setDescripcion("Hacer rapel en circuito de Volcatenango");
				trip1.setFecha(sdf.parse("02-025-2023"));
				trip1.setCosto(10.0);
				trip1.setCalificacion(9);
				
				Trip trip2 = new Trip();
				trip2.setId(2);
				trip2.setNomTrip("Deslizadero en el Picnic");
				trip2.setDescripcion("Emocionante deslizadero en el restaurante Picnic");
				trip2.setFecha(sdf.parse("07-09-2025"));
				trip2.setCosto(5.0);
				trip2.setCalificacion(6);
				
				Trip trip3 = new Trip();
				trip3.setId(3);
				trip3.setNomTrip("Comida y Flores");
				trip3.setDescripcion("Comida deliciosa mientras se disfruta un vivero natural");
				trip3.setFecha(sdf.parse("07-09-2024"));
				trip3.setCosto(25.0);
				trip3.setCalificacion(7);
				
				Trip trip4 = new Trip();
				trip4.setId(4);
				trip4.setNomTrip("Caminata el Tío Juan");
				trip4.setDescripcion("Hermosas caminatas por largos senderos rodeados de vegetación");
				trip4.setFecha(sdf.parse("07-09-2023"));
				trip4.setCosto(5.0);
				trip4.setCalificacion(6);
				
				lista.add(trip1);
				lista.add(trip2);
				lista.add(trip3);
				lista.add(trip4);
				
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				// Esto se hace siempre falle o no falle;
			}
			
			return lista;
	}


	@Override
	public Trip buscarPorId(Integer idTrip) {
		
		for (Trip trip : lista)
			if (trip.getId()==idTrip)
				return trip;
			
		return null;
	}
	
}
