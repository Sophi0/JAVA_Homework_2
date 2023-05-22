package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Driver;

public interface IDriverCRUDService {

	ArrayList<Driver> retrieveAllDrivers();
	
	ArrayList<Driver> retrieveDriverById(long id) throws Exception;
	
	ArrayList<Driver> deleteDriverById(long id) throws Exception;
	
	ArrayList<Driver> addnewDriver(Driver driver) throws Exception;
	
	ArrayList<Driver> updateDriverById(long id) throws Exception;
}
