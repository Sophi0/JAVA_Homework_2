package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.models.City;
import lv.venta.models.Trip;
import lv.venta.repos.ITripRepo;
import lv.venta.services.ITripService;

public class TripServiceImpl implements ITripService{
	
	@Autowired 
	private ITripRepo trRepo;

	@Override
	public ArrayList<Trip> selectTripByCityTitle(String title) throws Exception {
		if(title == null || title.isEmpty()) {
				throw new Exception ("Title does not exist");
		}
		ArrayList<Trip> matchingTrips = new ArrayList<>();
		for(Trip temp : trRepo.selectTripByCityTitle(title)) {
			if(hasCityWithTitle(temp, title)) {
				//if there is matching cities, it adds trip to the list
				matchingTrips.add(temp);
			}
		}
		if(matchingTrips.isEmpty()) {
			throw new Exception("There is no trip");
		}
		return matchingTrips;
	}
	
	//this method is needed, because it is checks if any of the cities in the trip have a matching title
	private boolean hasCityWithTitle(Trip temp, String title) {
		for(City city : temp.getCities()) {
			if(city.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Trip> selectTripsByDriverId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trip> selectTripsToday(LocalDateTime dateTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trip> changeTripDriverByDriverId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
