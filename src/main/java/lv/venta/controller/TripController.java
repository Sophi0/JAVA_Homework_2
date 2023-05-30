package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lv.venta.services.ITicketService;

@Controller
public class TripController {

	@Autowired
	private ITicketService ticketService;
	
	
}
