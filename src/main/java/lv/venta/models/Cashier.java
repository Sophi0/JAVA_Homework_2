package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "cashier_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cashier extends Person{
	
	@Column(name = "IDc")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idc;

	public Cashier(
			@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String name,
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String surname) {
		super(name, surname);
	}
	
	
}
