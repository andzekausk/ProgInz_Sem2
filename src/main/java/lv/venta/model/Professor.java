package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {
	@Id
	@Column(name="Idp")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idp;
	
	@Column(name="Name")
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp = "[A-Za-z ]+", message = "Only letters and space")
	private String name;
	
	@Column(name="Surname")
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp = "[A-Za-z ]+", message = "Only letters and space")
	private String surname;
	
	@Column(name="Degree")
	@NotNull
	private String degree;
	
	public Professor(String name, String surname, String degree) {
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
}
