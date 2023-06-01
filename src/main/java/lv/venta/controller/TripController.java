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
	
	
	@GetMapping(value = "/trip/showAll")	//localhost:8080/trip/showAll
	public String getAllDriversFunc(Model model) {
		model.addAttribute("trip", tripService.retrieveAllTrips());
		return "all-trip-page";	//will show all-drivers-page.html
	}
	
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
	
	@GetMapping(value = "/trip/showAll/driver/{id}")	//localhost:8080/trip/showAll/driver/{id}
	public String getAllTripsByDriverId(@PathVariable("id") long id, Model model) {
		try {
			model.addAttribute("trip", tripService.selectTripsByDriverIdd(id));
			return "all-trip-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "/trip/showAll/today")	//localhost:8080/trip/showAll/today
	public String getAllTripsToday(Model model) {
		try {
			model.addAttribute("trip", tripService.selectTripsToday());
			return "all-trip-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "/trip/changeDriver/{idt}/{idd}")	//localhost:8080/trip/changeDriver/1/1
	public String getChangeDriver(@PathVariable("idt") long idt, @PathVariable("idd") long idd, Model model) {
		try {
			tripService.changeTripDriverByDriverId(idt, idd);
			model.addAttribute("trip", tripService.retrieveAllTrips());
			return "redirect:/trip/showAll";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
}
