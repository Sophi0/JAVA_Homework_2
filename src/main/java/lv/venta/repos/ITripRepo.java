package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Trip;

public interface ITripRepo extends CrudRepository<Trip, Long>{

	Trip[] selectTripByCityTitle(String title);

	ArrayList<Trip> findByDriverId(long id);

	ArrayList<Trip> allTrips();


}
