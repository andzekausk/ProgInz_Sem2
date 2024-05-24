package lv.venta.model;

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
@MappedSuperclass //shii anotacija nozime, ka no sis klases nebus tabula, bet taas kolonas bus mantotas klases tabulaas
public class Person {
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
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
