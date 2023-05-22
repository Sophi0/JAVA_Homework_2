package lv.venta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.models.Trip;

public interface ITripService {

	ArrayList<Trip> selectTripByCityTitle(String title) throws Exception;
	
	ArrayList<Trip> selectTripsByDriverId(long id) throws Exception;
	
	ArrayList<Trip> selectTripsToday(LocalDateTime dateTime) throws Exception;
	
	ArrayList<Trip> changeTripDriverByDriverId(long id) throws Exception;
	
}
