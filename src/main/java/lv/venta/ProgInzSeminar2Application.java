package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar2Application.class, args);
	}

	@Bean
	public CommandLineRunner testDB(IStudentRepo studRepo, IProfessorRepo profRepo, ICourseRepo courseRepo,
			IGradeRepo gradeRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Karina", "Skirmante", "mg");
				Professor p2 = new Professor("Vija", "Vagale", "phd");
				Professor p3 = new Professor("Raita", "Rollande", "phd");
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);

				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Liga", "Jauka");
				Student s3 = new Student("Baiba", "Nejauka");
				studRepo.save(s1);
				studRepo.save(s2);
				studRepo.save(s3);

				Course c1 = new Course("Datu strukturas un algoritmi", 2, p1);
				Course c2 = new Course("Datubazes", 2, p2);
				Course c3 = new Course("Programmaturas inzenierija I", 4, p3);
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);

				gradeRepo.save(new Grade(4, c1, s1)); //Janis 4 DataStr
				gradeRepo.save(new Grade(7, c2, s1)); //Janis 7 DB
				gradeRepo.save(new Grade(10, c3, s1)); //Janis 10 ProgInz
				gradeRepo.save(new Grade(5, c1, s2)); //Liga 5 DataStr
				gradeRepo.save(new Grade(9, c3, s2)); //Liga 9 ProgInz
				gradeRepo.save(new Grade(8, c1, s3)); //Baiba 8 DataStr
				gradeRepo.save(new Grade(8, c3, s3)); //Baiba 8 ProgInz
			}
		};
	}

}
