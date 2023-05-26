package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Ticket;

public interface ITicketRepo extends CrudRepository<Ticket, Long>{

	ArrayList<Ticket> findByTripId(long idt);

}
