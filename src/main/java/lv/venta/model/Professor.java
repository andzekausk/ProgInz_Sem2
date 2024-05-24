package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "ProfessorTable")
@Entity
public class Professor extends Person{
	
	// ID naak no Person klases
	
	@Column(name="Degree")
//	@NotNull // janem nost prieksh single strategy
	private String degree;
	
	@OneToOne(mappedBy = "professor") //Course klases mainiigaa nosaukums
	@ToString.Exclude
	private Course course;
	
	
	
	public Professor(String name, String surname, String degree) {
		super(name, surname);
		setDegree(degree);
	}
}
