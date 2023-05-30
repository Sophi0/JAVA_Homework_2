package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.BusCategory;
import lv.venta.models.Driver;

public interface IDriverCRUDService {

	ArrayList<Driver> retrieveAllDrivers();
	
	Driver retrieveDriverById(long idd) throws Exception;
	
	public abstract void deleteDriverById(long idd) throws Exception;
	
	public abstract void addnewDriver(String name, String surname, BusCategory categories) throws Exception;
	
	public abstract void updateDriverById(long idd, String name, String surname, BusCategory categories) throws Exception;
}
