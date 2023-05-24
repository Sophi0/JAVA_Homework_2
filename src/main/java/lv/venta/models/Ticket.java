package lv.venta.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ticket_table")	
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ticket {

	@Column(name = "IDtk")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idtk;
	
	@Column(name = "purschaseDateTime")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	
	@Column(name = "Price")
	@Min(0)
	@Max(1000)
	private float price;
	
	@Column(name = "isChild")
	private boolean isChild;
	
	@ManyToOne
	@JoinColumn(name = "IDt")
	private Trip trips;
	
	@ManyToOne
	@JoinColumn(name = "IDc")
	private Cashier cashiers;
	
	public Ticket(@NotNull LocalDateTime dateTime, @Min(0) @Max(1000) float price, boolean isChild) {
		this.dateTime = dateTime;
		this.price = price;
		this.isChild = isChild;
	}

	public Ticket(@NotNull LocalDateTime dateTime, @Min(0) @Max(1000) float price, boolean isChild, Trip trips,
			Cashier cashiers) {
		super();
		this.dateTime = dateTime;
		this.price = price;
		this.isChild = isChild;
		this.trips = trips;
		this.cashiers = cashiers;
	}
	

	
	
}
