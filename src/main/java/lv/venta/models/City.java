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
	private String title;
	
	@Column(name = "adressForStation")
	@NotNull
	@Size(min = 3, max = 1000)
	@Pattern(regexp = "/[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš][*][0-1]+)?")
	public String city;
}
