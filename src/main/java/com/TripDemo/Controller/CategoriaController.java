package com.TripDemo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.TripDemo.model.Categoria;
import com.TripDemo.services.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService serviceCategorias;
	
	// 1. Listar (READ)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategorias.buscarTodas();
		model.addAttribute("categorias", lista);
		return "categorias/listado"; // Asumiendo que moviste listado.html a carpeta categorias
	}
	
	// 2. Mostrar Formulario de Creación (CREATE - GET)
	@GetMapping("/create")
	public String crear(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categorias/formCategoria";
	}
	
	// 3. Guardar (CREATE/UPDATE - POST)
	@PostMapping("/save")
	public String guardar(Categoria categoria, RedirectAttributes attributes) {
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado Exitosamente!");
		return "redirect:/categorias/index";
	}
	
	// 4. Editar (UPDATE - GET)
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCategoria, Model model) {
		Categoria cat = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", cat);
		return "categorias/formCategoria"; // Reutilizamos el mismo formulario
	}
	
	// 5. Eliminar (DELETE)
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attributes) {
		serviceCategorias.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "Registro Eliminado!");
		return "redirect:/categorias/index";
	}
}