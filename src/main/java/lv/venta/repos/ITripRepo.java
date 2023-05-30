package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;

public interface ITripRepo extends CrudRepository<Trip, Long>{

	ArrayList<Trip> findByCitiesTitle(String inputTitle);

	ArrayList<Ticket> findTicketsByIdt(long idt);

	ArrayList<Trip> findByDriverIdd(long idd);

	//Trip findTripByTripIdt(long idt);



}
