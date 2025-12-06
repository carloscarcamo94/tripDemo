package com.TripDemo.Controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		// 1. Cargamos los trips (puedes filtrar solo los 'Activos' si quieres)
        List<Trip> lista = tripService.buscarTodos();
        model.addAttribute("trips", lista);
        
        // 2. ¡IMPORTANTE! Cargamos las categorías para el buscador
        List<com.TripDemo.model.Categoria> categorias = serviceCategorias.buscarTodas();
        model.addAttribute("categorias", categorias);
        
        return "home";
	}
	
    @GetMapping("/search")
    public String buscar(@RequestParam(name="query", required=false) String query, 
                         @RequestParam(name="idCategoria", required=false) Integer idCategoria, 
                         Model model) {
        
        List<Trip> lista = null;
        
        // Lógica simple de filtrado (Prioridad: Categoría > Descripción > Todo)
        // Puedes combinarla si quieres hacer búsquedas más complejas
        if (idCategoria != null && idCategoria > 0) {
            lista = tripService.buscarPorCategoria(idCategoria);
        } else if (query != null && !query.isEmpty()) {
            lista = tripService.buscarPorDescripcion(query);
        } else {
            lista = tripService.buscarTodos();
        }
        
        model.addAttribute("trips", lista);
        
        // Devolvemos también las categorías para que el select no se quede vacío tras buscar
        model.addAttribute("categorias", serviceCategorias.buscarTodas());
        
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
	
	
}
