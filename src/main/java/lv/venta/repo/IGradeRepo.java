package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

	ArrayList<Grade> findByGrvalueLessThan(int i);

	ArrayList<Grade> findByStudentIdpe(int id);

	@Query(nativeQuery = true, value = "SELECT avg(grvalue) FROM grade_table where idc=(?1);") //?1 nozime ka funkcijas pirmais arguments nonaak tajaa vietaa
	float calculateAVGGradeInCourseId(int id);

}
