package lv.venta.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradeFilterService;

public class GradeFilterServiceImpl implements IGradeFilterService{

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		if(result.isEmpty()) throw new Exception("There are no failed grades");
		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesByStudentId(int id) throws Exception {
		if(id<1) throw new Exception("Id should be positive");
		if(!studRepo.existsById(id)) throw new Exception("Student with id '"+id+"' doesn't exist");
		ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
		if(result.isEmpty()) throw new Exception("There are no grades for this student");
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) throws Exception {
		/*@Query(nativeQuery = true, value = "SELECT SUM(price*quantity) FROM product_table;")
	float calculateTotalValueFromRepoProducts();*/
		
		if(id<1) throw new Exception("Id should be positive");
		if(!courseRepo.existsById(id)) throw new Exception("Course with id '"+id+"' doesn't exist");
		float result = gradeRepo.calculateAVGGradeInCourseId(id);
		if(result==0) throw new Exception("There are no grades for this course");
		return result;
	}

}
