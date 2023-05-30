package lv.venta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.models.Trip;

public interface ITripService {

	ArrayList<Trip> selectTripByCityTitle(String inputTitle) throws Exception;
	
	ArrayList<Trip> selectTripsByDriverIdd(long idd) throws Exception;
	
	ArrayList<Trip> selectTripsToday() throws Exception;
	
	public abstract void changeTripDriverByDriverId(long idd, long idt) throws Exception;
	
}
