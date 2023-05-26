package lv.venta.repos;


import org.springframework.data.repository.CrudRepository;

import lv.venta.models.BusCategory;
import lv.venta.models.Driver;

public interface IDriverRepo extends CrudRepository<Driver, Long>{

	Driver findByIdd(long idd);

	boolean existsByNameAndSurnameAndBcategory(String name, String surname, BusCategory bcategory);

	Driver findByNameAndSurnameAndBcategory(String name, String surname, BusCategory bcategory);

	void deleteDriverById(long idd);

}
