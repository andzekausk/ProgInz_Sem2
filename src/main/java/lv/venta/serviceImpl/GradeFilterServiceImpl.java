package lv.venta.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.model.Grade;
import lv.venta.repo.IGradeRepo;
import lv.venta.service.IGradeFilterService;

public class GradeFilterServiceImpl implements IGradeFilterService{

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		if(result.isEmpty()) throw new Exception("There are no failed grades");
		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesByStudentId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
