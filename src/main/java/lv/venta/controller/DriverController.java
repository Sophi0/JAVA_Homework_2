package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lv.venta.models.Driver;
import lv.venta.services.IDriverCRUDService;

@Controller
public class DriverController {
	
	@Autowired
	private IDriverCRUDService driverCRUDService;
	
	@GetMapping(value = "/driver/showAll")	//localhost:8080/driver/showAll
	public String getAllDriversFunc(Model model) {
		model.addAttribute("driver", driverCRUDService.retrieveAllDrivers());
		return "all-drivers-page";	//will show all-drivers-page.html
	}
	
	@GetMapping(value = "/driver/showAll/{id}")	//localhost:8080/driver/showAll/2
	public String getAllDriversByDriverIdFunc(@PathVariable(name = "id") long id, Model model) throws Exception{
		try {
			model.addAttribute("driver", driverCRUDService.retrieveDriverById(id));
			return "all-drivers-page";	//will show all-drivers-page.html
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";	//will show error-page.html
		}
	}
	
	@GetMapping(value = "/driver/remove/{id}")	//localhost:8080/driver/remove/2
	public String getRemoveDriverFunc(@PathVariable("id") long idd, Model model) {
		try {
			driverCRUDService.deleteDriverById(idd);
			model.addAttribute("driver", driverCRUDService.retrieveAllDrivers());
			return "all-drivers-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "/driver/addNew")	//localhost:8080/driver/addNew
	public String getAddNewDriverFunc(Model model) {
		model.addAttribute("driver", new Driver());
		return "add-driver-page";	//will call add-driver-page.html
	}
	
	@PostMapping(value = "/driver/addNew")	//localhost:8080/driver/addNew
	public String postAddNewDriverFunc(@Valid Driver driver, BindingResult result) {
		if(!result.hasErrors()) {
			try {
				driverCRUDService.addnewDriver(driver.getName(), driver.getSurname(), driver.getCategories());
				return "redirect:/driver/showAll";
			}
			catch (Exception e) {
				return "redirect:/error-page";
			}
		}
		else {
			return "add-driver-page";
		}
	}
	
	@GetMapping(value = "/driver/update/{id}")	//localhost:8080/driver/update/{id}
	public String getUpdateDriverByIdfunc(@PathVariable("id") long id, Model model) {
		try {
			Driver driver = driverCRUDService.retrieveDriverById(id);
			model.addAttribute("driver", driver);
			return "update-driver-page";	//will call update-driver-page.html
		}
		catch (Exception e) {
			model.addAttribute("packetError", e.getMessage());
			return "error-page";	//will call error-page.html
		}
	}
	
	@PostMapping(value = "/driver/update/{id}")
	public String postUpdateDriverByIdFunc(@PathVariable("id") long id, @Valid Driver driver, BindingResult result) {
		if(!result.hasErrors()) {
			try {
				driverCRUDService.updateDriverById(id, driver.getName(), driver.getSurname(), driver.getCategories());
				return "redirect:/driver/showAll/" + id;
			}
			catch (Exception e) {
				return "redirect:/error-page";
			}
		}
		else {
			return "update-driver-page";
		}
	}
	
}
