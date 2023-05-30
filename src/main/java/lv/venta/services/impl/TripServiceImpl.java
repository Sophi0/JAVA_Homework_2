package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.City;
import lv.venta.models.Trip;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITripRepo;
import lv.venta.services.ITripService;

@Service
public class TripServiceImpl implements ITripService{
	
	@Autowired 
	private ITripRepo trRepo;
	@Autowired
    private IDriverRepo drRepo;

	@Override
	public ArrayList<Trip> selectTripByCityTitle(String inputTitle) throws Exception {
		if(inputTitle.length() == 0 || inputTitle.isEmpty()) {
				throw new Exception ("Title does not exist");
		}
		ArrayList<Trip> matchingTrips = new ArrayList<>();
		for(Trip temp : trRepo.findByCitiesTitle(inputTitle)) {
			if(hasCityWithTitle(temp, inputTitle)) {
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
	public ArrayList<Trip> selectTripsByDriverId(long idd) throws Exception {
		if(idd > 0) {
			ArrayList<Trip> filteredResults = trRepo.findByDriverIdd(idd);
			for(Trip temp : trRepo.findAll()) {
				if(Objects.equals(temp.getDriver().getIdd(), idd)) {
					filteredResults.add(temp);
				}
			}
			return filteredResults;
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public ArrayList<Trip> selectTripsToday(LocalDateTime dateTime) throws Exception {
		ArrayList<Trip> tripsToday = new ArrayList<>();
		//I created function allTrips to output list of trips
		for(Trip trip : trRepo.findAll()) {
			//if trip date and time matches, it will be added
			if(trip.getDateTime().toLocalDate().isEqual(dateTime.toLocalDate())) {
				tripsToday.add(trip);
			}
		}
		return tripsToday;
	}

	@Override
	public void changeTripDriverByDriverId(long idd, long idt) throws Exception {
		if(idd > 0) {
			for(Trip temp : trRepo.findAll()) {
				//if the id of the current trip object 'temp'is equal to the provided id
				if(Objects.equals(temp.getIdt(), idt)) {
					//so we set the driver of the current trip object 'temp' to the driver object 
					temp.setDriver(drRepo.findById(idd).get());
				}
			}
		}
		else {
			throw new Exception ("ID is not correct");
		}
	}

}
