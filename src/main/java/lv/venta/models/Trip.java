package lv.venta.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "trip_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trip {

	@Column(name = "IDt")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idt;
	
	@Column(name = "startDateTime")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	
	@Column(name = "Duration")
	private int durationInMinutes;
	
	@ManyToOne
	@JoinColumn(name = "IDd")
	private Driver driver;
	
	@OneToMany(mappedBy = "trips")
	@ToString.Exclude
	private Collection<Ticket> tickets;
	
	@ManyToMany(mappedBy = "trips")
	@ToString.Exclude
	private Collection<City> cities = new ArrayList<>();
	

	public Trip(@NotNull LocalDateTime dateTime, int durationInMinutes) {
		this.dateTime = dateTime;
		this.durationInMinutes = durationInMinutes;
	}
	
	
}
