package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Grade;

public interface IGradeFilterService {
	
	ArrayList<Grade> selectFailedGrades() throws Exception;
	
	ArrayList<Grade> selectGradesByStudentId(int id) throws Exception;
	
	float calculateAVGGradeInCourseId(int id) throws Exception;
}
