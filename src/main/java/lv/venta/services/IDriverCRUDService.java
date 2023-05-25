package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.BusCategory;
import lv.venta.models.Driver;

public interface IDriverCRUDService {

	ArrayList<Driver> retrieveAllDrivers();
	
	ArrayList<Driver> retrieveDriverById(long id) throws Exception;
	
	ArrayList<Driver> deleteDriverById(long id) throws Exception;
	
	public abstract void addnewDriver(String name, String surname, BusCategory bcategory) throws Exception;
	
	public abstract void updateDriverById(long id, String name, String surname, BusCategory bcategory) throws Exception;
}
