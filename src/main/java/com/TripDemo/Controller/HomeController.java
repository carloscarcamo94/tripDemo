package com.TripDemo.Controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.TripDemo.model.Categoria;
import com.TripDemo.model.Trip;
import com.TripDemo.services.ICategoriaService;
import com.TripDemo.services.ITripService;

@Controller
public class HomeController {

	@Autowired
	private ITripService tripService;
	
	@Autowired
	private ICategoriaService serviceCategorias;
	
	@GetMapping ("/")
	public String mostrarHome(Model model) {
		
		List<Trip> lista = tripService.buscarTodos();
		model.addAttribute("trips", lista);
		
		return "home";
	}
	
//	@GetMapping ("/categorias")
//	public String mostrarListado(Model model) {
		
//		List<String> lista = new LinkedList<>();
//		lista.add("Montaña");
//		lista.add("Ciudad");
//		lista.add("Pueblo");
//		lista.add("Playa");
//		lista.add("Lago");
//		lista.add("Muelle");
//		model.addAttribute("lista", lista);
//		
//		return "listado";
//	}
	
	@GetMapping ("/detalle")
	public String mostrarDetalle(Model model) {
		
		Trip trip = new Trip();
		trip.setNombre("Rapel en Volcatenango");
		trip.setDescripcion("Aventura extrema en un circuito conectado");
		trip.setFecha(new Date());
		trip.setCosto(10.0);
		trip.setCalificacion(9);
		model.addAttribute(trip);
		
		return "trip/detalle";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Trip> lista = tripService.buscarTodos();
		model.addAttribute("trips", lista);
		
		return "trip/tabla";
	}
	
	
}
