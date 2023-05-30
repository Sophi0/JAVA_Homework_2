package lv.venta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.models.Cashier;
import lv.venta.models.Ticket;

public interface ITicketService {

	ArrayList<Ticket> selectAllChildTickets();
	
	ArrayList<Ticket> selectAllTicketsWherePriceIsLow(float inputPrice);
	
	ArrayList<Ticket> selectAllTicketsByTripId(long idt) throws Exception;
	
	float calculateIncomeOfTripByTripId(long idt) throws Exception;
	
	float calculateIncomeOfCashierByCashierId(long idc) throws Exception;
	
	public abstract void insertNewTicketByTripId(long idt, float price, boolean isChild, Cashier cashier) throws Exception;
}
