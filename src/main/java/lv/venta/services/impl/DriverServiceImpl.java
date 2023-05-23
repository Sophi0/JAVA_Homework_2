package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.models.Driver;
import lv.venta.repos.IDriverRepo;
import lv.venta.services.IDriverCRUDService;

public class DriverServiceImpl implements IDriverCRUDService{
	
	@Autowired
	private IDriverRepo drRepo;

	@Override
	public ArrayList<Driver> retrieveAllDrivers() {
		return (ArrayList<Driver>) drRepo.findAll();
	}

	@Override
	public ArrayList<Driver> retrieveDriverById(long id) throws Exception {
		if(id > 0) {
			ArrayList<Driver> filteredResults = drRepo.findByDriverIdd(id);	
			return filteredResults;
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public ArrayList<Driver> deleteDriverById(long id) throws Exception {
		if(id > 0) {
			ArrayList<Driver> filteredResults = drRepo.findByDriverIdd(id);	
			if(!filteredResults.isEmpty()) {
				//delete the driver from the repository
				drRepo.delete(filteredResults.get(0));
				//return the updated list of drivers after we deleted driver
				return retrieveAllDrivers();
			}
			else {
				throw new Exception("Driver not found");
			}
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}


	@Override
	public ArrayList<Driver> addnewDriver(Driver driver) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Driver> updateDriverById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
