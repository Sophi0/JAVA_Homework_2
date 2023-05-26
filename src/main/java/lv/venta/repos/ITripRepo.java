package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Trip;

public interface ITripRepo extends CrudRepository<Trip, Long>{

	Trip[] selectTripByCityTitle(String title);

	ArrayList<Trip> findByDriverId(long idd);

	ArrayList<Trip> allTrips();

	Trip findTripByTripId(long idt);



}
