package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.BusCategory;
import lv.venta.models.Driver;
import lv.venta.repos.IDriverRepo;
import lv.venta.services.IDriverCRUDService;

@Service
public class DriverServiceImpl implements IDriverCRUDService{
	
	@Autowired
	private IDriverRepo drRepo;

	@Override
	public ArrayList<Driver> retrieveAllDrivers() {
		return (ArrayList<Driver>) drRepo.findAll();
	}

	@Override
	public Driver retrieveDriverById(long idd) throws Exception {
		if(idd > 0) {
			return drRepo.findById(idd).get();
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public void deleteDriverById(long idd) throws Exception {
		if(idd > 0) {
			drRepo.deleteById(idd);
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}


	@Override
	public void addnewDriver(String name, String surname, BusCategory categories) throws Exception {
		if (!(drRepo.findByName(name) && drRepo.findBySurname(surname) && drRepo.findByCategories(categories))) {
			drRepo.save(new Driver(name, surname, categories));
		}
		 else {
			 throw new Exception("Driver already exists");
		}
	}


	@Override
	public void updateDriverById(long idd, String name, String surname, BusCategory categories) throws Exception {
		if(idd > 0) {
			if(drRepo.existsById(idd)) {
				Driver temp = drRepo.findById(idd).get();
				temp.setName(name);
				temp.setSurname(surname);
				temp.setCategories(categories);

				drRepo.save(temp);
			}
			else {
				throw new Exception("There is no product with this ID");
			}
		}
		else {
			throw new Exception("ID needs to be positive");
		}	
	}

	

}
