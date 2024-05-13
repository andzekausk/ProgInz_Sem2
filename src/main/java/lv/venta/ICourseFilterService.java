package lv.venta;

import java.util.ArrayList;

import lv.venta.model.Course;

public interface ICourseFilterService {
	
	ArrayList<Course> selectCoursesByCreditpoints(int creditpoints) throws Exception;
	
	Course selectCourseByProfessorId(int id) throws Exception;
	
	ArrayList<Course> selectCoursesByStudentId(int id) throws Exception;
		
}
