package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.BusCategory;
import lv.venta.models.Driver;

public interface IDriverRepo extends CrudRepository<Driver, Long>{

	Driver findByIdd(long id);

	boolean existsByNameAndSurnameAndBcategory(String name, String surname, BusCategory bcategory);

	Driver findByNameAndSurnameAndBcategory(String name, String surname, BusCategory bcategory);

	void deleteDriverById(long id);

}
