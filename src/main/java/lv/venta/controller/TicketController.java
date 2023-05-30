package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lv.venta.models.Ticket;
import lv.venta.services.ITicketService;


@Controller
public class TicketController {

	@Autowired
	private ITicketService ticketService;
	
	//CHECK FROM THIRD FUNCTION. MAYBE NEED TO CHANGE IN TICKET CLASS ISCHILD GET AND SET PARAMETRS
	
	@GetMapping(value = "/ticket/showAll/isChild")	//localhost:8080/ticket/showAll/isChild
	public String getAllChildren(Model model) {
		model.addAttribute("ticket", ticketService.selectAllChildTickets());
		return "all-ticket-page";
	}
	
	@GetMapping(value = "/ticket/showAll/less/{price}")	//localhost:8080/ticket/showAll/less/{price}
	public String getAllTicketsLessPrice(Model model, @PathVariable("price") float price) {
		try {
			model.addAttribute("ticket", ticketService.selectAllTicketsWherePriceIsLow(price));
			return "all-ticket-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "/ticket/showAll/trip/{id}")	//localhost:8080/ticket/showAll/trip/{id}
	public String getAllTicketsForTripsByIdFunc(Model model, @PathVariable("id") long idt) {
		try {
			model.addAttribute("ticket", ticketService.selectAllTicketsByTripId(idt));
			return "all-ticket-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "/ticket/calculate/trip/{id}")	//localhost:8080/ticket/calculate/trip/{id}
	public String getIncomeForTripById(Model model, @PathVariable("id") long id) {
		try {
			model.addAttribute("ticket", ticketService.calculateIncomeOfTripByTripId(id));
			return "all-ticket-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "/ticket/calculate/cashier/{id}")	//localhost:8080/ticket/calculate/cashier/{id}
	public String getIncomeForCashierByid(Model model, @PathVariable("id") long id) {
		try {
			model.addAttribute("ticket", ticketService.calculateIncomeOfCashierByCashierId(id));
			return "all-ticket-page";
		}
		catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping(value = "ticket/add/{id}")	//localhost:8080/ticket/add/{id}
	public String getAddTicketToTripById(@PathVariable("id") long id, Model model) {
		model.addAttribute("ticket", new Ticket());
		return "add-ticket-page";
	}
	
	/*
	@PostMapping("/ticket/add/{id}")
    public String postAddTicketToTripById(@Valid Ticket ticket, BindingResult result, @PathVariable("id") long id) {
        if (!result.hasErrors()) {
            try {
                ticketService.insertNewTicketByTripId(id, ticket.getPrice(), ticket.getIsChild(), ticket.getCashiers());
                return "redirect:/ticket/showAll/trip/" + id;
            } catch (Exception e) {
                return "redirect:/error";
            }
        } else return "add-ticket-page";
    }
    */
}
