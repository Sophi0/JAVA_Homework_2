package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Cashier;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.ICashierRepo;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;
import lv.venta.services.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService{
	
	@Autowired
    private ITicketRepo tkRepo;
    @Autowired
    private ITripRepo trRepo;
    @Autowired 
    private ICashierRepo chRepo;
    
	@Override
	public ArrayList<Ticket> selectAllChildTickets() {
			ArrayList<Ticket> chTickets = new ArrayList<>();
			for(Ticket temp : tkRepo.findAll()) {
				if(temp.getChild()) {
					chTickets.add(temp);
				}
			}
			return chTickets;
		}
	
	
	@Override
	public ArrayList<Ticket> selectAllTicketsWherePriceIsLow(float inputPrice) {
		ArrayList<Ticket> lowPriceTk = new ArrayList<>();
		for(Ticket temp : tkRepo.findAll()) {
			if(temp.getPrice() < inputPrice) {
				lowPriceTk.add(temp);
			}
		}
		return lowPriceTk;
	}

	@Override
	public ArrayList<Ticket> selectAllTicketsByTripId(long idt) throws Exception {
		if(idt > 0) {
			return tkRepo.findByTripsIdt(idt);	
		}
		else {
			throw new Exception("ID must be positive");
		}
		
	}
	
	@Override
	public float calculateIncomeOfTripByTripId(long idt) throws Exception {
		if(idt > 0) {
			float totalIncome = 0;
			for(Ticket temp : selectAllTicketsByTripId(idt)) {
				totalIncome += temp.getPrice();
			}
			return totalIncome;
		}
		else {
			throw new Exception ("ID need to be positive");
		}
	}
	
	@Override
	public float calculateIncomeOfCashierByCashierId(long idc) throws Exception {
		if(idc > 0) {
			float totalIncome = 0;
			for(Ticket temp : chRepo.findById(idc).get().getTickets()) {
				totalIncome += temp.getPrice();
			}
			return totalIncome;
		}
		else {
			throw new Exception ("ID need to be positive");
		}
	}
	
	@Override
	public void insertNewTicketByTripId(long idt, float price, boolean child, long idc) throws Exception {
		if(idt > 0 && idc > 0) {
			Trip trip = trRepo.findById(idt).get();
			Ticket ticket = new Ticket();
			ticket.setTrips(trip);
			ticket.setPrice(price);
			ticket.setChild(child);
			//ticket.setCashiers(cashier);
			
			trip.getTickets().add(ticket);
			trRepo.save(trip);
			
	    } 
		else {
	        throw new Exception("ID needs to be positive");
	    }
	}

}
