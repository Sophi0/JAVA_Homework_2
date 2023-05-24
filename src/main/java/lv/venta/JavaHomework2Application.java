package lv.venta;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.BusCategory;
import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.ICashierRepo;
import lv.venta.repos.ICityRepo;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;

@SpringBootApplication
public class JavaHomework2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaHomework2Application.class, args);
	}

	@Bean
	public CommandLineRunner testModel(ICashierRepo chRepo, ICityRepo ctRepo, IDriverRepo drRepo, ITicketRepo tkRepo, ITripRepo trRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Cashier ch1 = new Cashier("Janis", "Cakste");
				Cashier ch2 = new Cashier("Luize", "Smirnova");
				chRepo.save(ch1);
				chRepo.save(ch2);
				
				Driver dr1 = new Driver("Karlis", "Liepins", BusCategory.minibus);
				Driver dr2 = new Driver("Ieva", "Gridneva", BusCategory.schoolbus);
				drRepo.save(dr1);
				drRepo.save(dr2);
				
				City c1 = new City("Ventspils", "Kuldigas iela 5");
				City c2 = new City("Riga", "Pragas iela 1");
				ctRepo.save(c1);
				ctRepo.save(c2);
				
				
				Trip tr1 = new Trip(LocalDateTime.of(2023, 5, 16, 12, 10), 3f);
				Trip tr2 = new Trip(LocalDateTime.of(2023, 5, 16, 13, 55), 2.5f);
				Trip tr3 = new Trip(LocalDateTime.of(2023, 5, 16, 19, 00), 5f, dr1, new ArrayList<City>(List.of(c1)));
				trRepo.save(tr1);
				trRepo.save(tr2);
				trRepo.save(tr3);
				
				tr1.addCity(c1);
				trRepo.save(tr1);
				
				c1.addTrip(tr3);
				ctRepo.save(c1);
				
				Ticket tk1 = new Ticket(LocalDateTime.of(2023, 3, 15, 15, 30), 7.55f, false, tr1, ch2);
				Ticket tk2 = new Ticket(LocalDateTime.of(2023, 3, 15, 15, 45), 3.25f, true, tr2, ch1);
				Ticket tk3 = new Ticket(LocalDateTime.of(2023, 3, 15, 18, 20), 4.44f, true, tr1, ch1);
				tkRepo.save(tk1);
				tkRepo.save(tk2);
				tkRepo.save(tk3);
				
			}
		};
	}
}
