package com.TripDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TripDemo.model.Trip;
import com.TripDemo.services.ITripService;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private ITripService servicesTrip;
	
	@GetMapping("view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		
		Trip trip = servicesTrip.buscarPorId(idTrip);
		System.out.println("idTrip: " + trip.getId());
		model.addAttribute("idTrip", trip.getId());
		
		return "trip/detalle";
	}
}
