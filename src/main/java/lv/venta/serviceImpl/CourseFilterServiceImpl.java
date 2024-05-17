package lv.venta.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService{

	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public ArrayList<Course> selectCoursesByCreditpoints(int creditpoints) throws Exception {
		if(creditpoints<0||creditpoints>20) throw new Exception("Problems with input args");
		ArrayList<Course> result = courseRepo.findByCreditpoints(creditpoints);
		if(result.isEmpty()) throw new Exception("There are no courses with "+creditpoints+" creditpoints");
		return result;
	}

	@Override
	public Course selectCourseByProfessorId(int id) throws Exception {
		if(id<1) throw new Exception("Problems with input args");
		if(!profRepo.existsById(id)) throw new Exception("Professor with id '"+id+"' doesn't exist");
		Course result = courseRepo.findByProfessorIdp(id);
		if(result==null) throw new Exception("There is no course linkage to this professor");
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if(id<1) throw new Exception("Problems with input args");
		if(!studRepo.existsById(id)) throw new Exception("Student with id '"+id+"' doesn't exist");
		ArrayList<Course> result = courseRepo.findByGradeStudentIds(id);
		if(result.isEmpty()) throw new Exception("There are no courses for this student");
		return result;
	}
	
}
