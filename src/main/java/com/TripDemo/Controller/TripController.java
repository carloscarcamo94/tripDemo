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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String guardar(@ModelAttribute Trip trip, RedirectAttributes attributes) {
		servicesTrip.guardar(trip);
		
		// Agregamos el mensaje flash
		attributes.addFlashAttribute("msg", "¡Registro guardado exitosamente!");
		
		return "redirect:/trips/index"; // Redirigimos a la tabla de Trips
	}
	
	// 1. Método para mostrar el formulario de EDICIÓN
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idTrip, Model model) {
        // Buscamos el trip existente
        Trip trip = servicesTrip.buscarPorId(idTrip);
        
        // Lo pasamos al modelo (el formulario se llenará solo gracias al binding)
        model.addAttribute("trip", trip);
        
        // ¡IMPORTANTE! Hay que volver a cargar las categorías para el <select>
        List<Categoria> listaCategorias = servicesCategoria.buscarTodas();
        model.addAttribute("categorias", listaCategorias);
        
        return "trip/formTrip"; // Reusamos el mismo formulario
    }

    // 2. Método para ELIMINAR
    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idTrip, RedirectAttributes attributes) {
		servicesTrip.eliminar(idTrip);
		
		// Agregamos el mensaje flash
		attributes.addFlashAttribute("msg", "¡Registro eliminado exitosamente!");
		
		return "redirect:/trips/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Trip> lista = servicesTrip.buscarTodos();
		model.addAttribute("trips", lista);
		
		return "trip/tabla";
	}

}
