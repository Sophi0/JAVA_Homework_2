package lv.venta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
				
				Ticket tk1 = new Ticket(LocalDateTime.of(2023, 3, 15, 15, 30), 7.55f, false);
				Ticket tk2 = new Ticket(LocalDateTime.of(2023, 3, 15, 15, 45), 3.25f, true);
				tkRepo.save(tk1);
				tkRepo.save(tk2);
				
				Trip tr1 = new Trip(LocalDateTime.of(2023, 5, 16, 12, 10), 3);
				Trip tr2 = new Trip(LocalDateTime.of(2023, 5, 16, 13, 55), 2.5f);
				trRepo.save(tr1);
				trRepo.save(tr2);
			}
		};
	}
}
