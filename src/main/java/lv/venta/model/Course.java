package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "CourseTable")
@Entity
public class Course {
	
	@Id
	@Column(name="Idc")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idc;
	
	@Column(name="Title")
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp = "[A-Za-z ]+", message = "Only letters and space")
	private String title;
	
	@Column(name="Creditpoints")
	@Min(1)
	@Max(20)
	private int creditpoints;
	
	//TODO uztaisit konstruktoru pec saites pievienosanu ar profesoru
}
