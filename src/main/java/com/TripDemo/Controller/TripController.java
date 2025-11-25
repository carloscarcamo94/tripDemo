package com.TripDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TripDemo.model.Categoria;
import com.TripDemo.model.Trip;
import com.TripDemo.services.ICategoriaService;
import com.TripDemo.services.ITripService;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private ITripService servicesTrip;
	
	@Autowired
	private ICategoriaService servicesCategoria;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
	    Trip trip = servicesTrip.buscarPorId(idTrip);
	    if (trip == null) {
	        return "redirect:/"; // o mostrar una vista de error
	    }

	    model.addAttribute("trip", trip);
	    model.addAttribute("trips", servicesTrip.buscarTodos());
	    return "trip/detalle";
	}
	
	// --- NUEVO: Método para mostrar el formulario ---
	@GetMapping("/create")
	public String crear(Model model) {
			
		// 1. Pasamos un objeto Trip vacío para vincular los campos del formulario
		model.addAttribute("trip", new Trip());
			
		// 2. Recuperamos la lista de categorías de la BD
		List<Categoria> listaCategorias = servicesCategoria.buscarTodas();
			
		// 3. Pasamos la lista al modelo para usarla en el <select>
		model.addAttribute("categorias", listaCategorias);
			
		return "trip/formTrip"; // Buscamos el archivo en templates/trip/formTrip.html
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Trip trip) {
		
		// 1. Guardamos el objeto Trip en la base de datos usando el servicio
		servicesTrip.guardar(trip);
		
		// 2. Redirigimos al listado principal (o a la tabla) para ver el resultado
		return "redirect:/"; 
	}

}
