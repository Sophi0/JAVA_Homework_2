package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lv.venta.services.ITripService;

@Controller
public class TripController {

	@Autowired
	private ITripService tripService;
	
	
	@GetMapping(value = "/trip/showAll/city/{title}")	//localhost:8080/trip/showAll/city/{title}
	public String getAllCityByCityTitleFunc(@PathVariable("title") String title, Model model) {
		try {
			model.addAttribute("trip", tripService.selectTripByCityTitle(title));
			return "all-trip-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
}
