package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person {
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 30)
	@Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters")
	private String surname;

	public Person(
			@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String name,
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	
}
