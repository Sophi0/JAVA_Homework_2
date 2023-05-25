package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;


import lv.venta.models.BusCategory;
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
			ArrayList<Driver> filteredResults = drRepo.findByIdd(id);	
			return filteredResults;
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public ArrayList<Driver> deleteDriverById(long id) throws Exception {
		if(id > 0) {
			ArrayList<Driver> filteredResults = drRepo.findByIdd(id);	
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
	public void addnewDriver(String name, String surname, BusCategory bcategory) throws Exception {
		if (drRepo.existsByNameAndSurnameAndBcategory(name, surname, bcategory)) {
			throw new Exception("Driver already exists");
		}
		 else {
			Driver newDriver = new Driver(name, surname, bcategory);
			drRepo.save(newDriver); 
		}
	}


	@Override
	public void updateDriverById(long id, String name, String surname, BusCategory bcategory) throws Exception {
		if(id > 0) {
			if(drRepo.existsById(id)) {
				Driver temp = drRepo.findById(id).get();
				temp.setName(name);
				temp.setSurname(surname);
				temp.setBcategory(bcategory);

				drRepo.save(temp);
			}
			else {
				throw new Exception("There is no product with this ID");
			}
		}
		else {
			throw new Exception("ID nees to be positive");
		}	
	}

	

}
