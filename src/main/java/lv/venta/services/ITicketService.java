package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Ticket;

public interface ITicketService {

	ArrayList<Ticket> selectAllChildTickets(boolean isChild) throws Exception;
	
	ArrayList<Ticket> selectAllTicketsByTripId(long id) throws Exception;
	
	ArrayList<Ticket> calculateIncomeOfTripBytripId(long id) throws Exception;
	
	ArrayList<Ticket> calculateIncomeOfCashierByCashierId(long id) throws Exception;
	
	ArrayList<Ticket> insertNewTicketByTripId(long id) throws Exception;
}
