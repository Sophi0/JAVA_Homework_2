package lv.venta.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
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
	
	//city
	//driver
	
	@Column(name = "startDateTime")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	
	@Column(name = "Duration")
	private int durationInMinutes;

	public Trip(@NotNull LocalDateTime dateTime, int durationInMinutes) {
		this.dateTime = dateTime;
		this.durationInMinutes = durationInMinutes;
	}
	
	
}
