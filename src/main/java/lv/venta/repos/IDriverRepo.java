package lv.venta.repos;


import org.springframework.data.repository.CrudRepository;

import lv.venta.models.BusCategory;
import lv.venta.models.Driver;

public interface IDriverRepo extends CrudRepository<Driver, Long>{

	boolean findByName(String name);

	boolean findBySurname(String surname);

	boolean findByCategories(BusCategory categories);

	//Driver findBy(long idd);

	//boolean existsByNameAndSurnameAndBcategory(String name, String surname, BusCategory bcategory);

	//Driver findByNameAndSurnameAndBcategory(String name, String surname, BusCategory bcategory);

	//void deleteDriverByIdd(long idd);

}
