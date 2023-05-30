package lv.venta.models;

import java.util.Collection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "driver_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Driver extends Person{
	
	@Column(name = "IDd")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idd;	
	
	
	@Column(name = "Categories")
	@NotNull
	private BusCategory categories;
	
	@OneToMany(mappedBy = "driver")
	@ToString.Exclude
	private Collection<Trip> trips;
	

	public Driver(
			@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String name,
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String surname,
			@NotNull BusCategory categories) {
		super(name, surname);
		this.categories = categories;
	}
	
	
}
