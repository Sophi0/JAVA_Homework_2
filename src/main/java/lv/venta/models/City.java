package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "city_table")	
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {
	
	@Column(name = "IDct")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idct;	
	
	@Column(name = "Title")
	@NotNull
	@Size(min = 3, max = 30)
	@Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+?")
	private String title;
	
	@Column(name = "adressForStation")
	@NotNull
	@Size(min = 3, max = 1000)
	//@Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([\\ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+[0-9]+)?")
	private String city;
	
	@ManyToMany
	@JoinTable(name = "trip_city_table", 
	joinColumns = @JoinColumn(name = "IDct"), 
	inverseJoinColumns = @JoinColumn(name = "IDt"))
	@ToString.Exclude
	private Collection<Trip> trips = new ArrayList<>();
	

	public City(@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+?") String title,
			@NotNull @Size(min = 3, max = 1000) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš][*][0-9]+)?") String city) {
		this.title = title;
		this.city = city;
	}
	
	public void addTrip(Trip inputTrip) {
		if(!trips.contains(inputTrip)) {
			trips.add(inputTrip);
		}
	}
	
	public void removeTrip(Trip inputTrip) {
		if(trips.contains(inputTrip)) {
			trips.remove(inputTrip);
		}
	}
}
