package com.TripDemo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.TripDemo.model.Trip;

@Controller
public class HomeController {

	@GetMapping ("/")
	public String mostrarHome() {
		return "home";
	}
	
	@GetMapping ("/listaCategoria")
	public String mostrarListado(Model model) {
		
		List<String> lista = new LinkedList<>();
		lista.add("Montaña");
		lista.add("Ciudad");
		lista.add("Pueblo");
		lista.add("Playa");
		lista.add("Lago");
		lista.add("Muelle");
		model.addAttribute("lista", lista);
		
		return "listado";
	}
	
	@GetMapping ("trip/detalle")
	public String mostrarDetalle(Model model) {
		
		Trip trip = new Trip();
		trip.setNomTrip("Rapel en Volcatenango");
		trip.setDescripcion("Aventura extrema en un circuito conectado");
		trip.setFecha(new Date());
		trip.setCosto(10.0);
		trip.setDireccion("Km 18 1/2, Carretera al Boquerón, Santa Tecla, La Libertad");
		trip.setCalificacion(9);
		model.addAttribute(trip);
		
		return "trip/detalle";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Trip> lista = getTrips();
		model.addAttribute("trips", lista);
		
		return "trip/tabla";
	}
	
	private List<Trip> getTrips(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		List<Trip> lista = new LinkedList<>();
		
		try {
			Trip trip1 = new Trip();
			trip1.setId(1);
			trip1.setNomTrip("Rapel en Volcatenango");
			trip1.setDescripcion("Hacer rapel en circuito de Volcatenango");
			trip1.setFecha(sdf.parse("02-025-2023"));
			trip1.setCosto(10.0);
			trip1.setDireccion("Km 18 1/2, Carretera al Boquerón, Santa Tecla, La Libertad");
			trip1.setCalificacion(9);
			
			Trip trip2 = new Trip();
			trip2.setId(2);
			trip2.setNomTrip("Deslizadero en el Picnic");
			trip2.setDescripcion("Emocionante deslizadero en el restaurante Picnic");
			trip2.setFecha(sdf.parse("07-09-2025"));
			trip2.setCosto(5.0);
			trip2.setDireccion("Km 3, Carretera al Boquerón, Santa Tecla");
			trip2.setCalificacion(6);
			
			Trip trip3 = new Trip();
			trip3.setId(3);
			trip3.setNomTrip("Comida y Flores");
			trip3.setDescripcion("Comida deliciosa mientras se disfruta un vivero natural");
			trip3.setFecha(sdf.parse("07-09-2024"));
			trip3.setCosto(25.0);
			trip3.setDireccion("Carretera los Naranjos, 5, Sonsonate");
			trip3.setCalificacion(7);
			
			Trip trip4 = new Trip();
			trip4.setId(4);
			trip4.setNomTrip("Caminata el Tío Juan");
			trip4.setDescripcion("Hermosas caminatas por largos senderos rodeados de vegetación");
			trip4.setFecha(sdf.parse("07-09-2023"));
			trip4.setCosto(5.0);
			trip4.setDireccion("Km 5, Carretera al Boquerón, Santa Tecla");
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
}
