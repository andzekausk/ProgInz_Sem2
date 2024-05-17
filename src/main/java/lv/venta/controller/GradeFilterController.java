package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.service.IGradeFilterService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {
	
	@Autowired
	private IGradeFilterService gradeFitlerService;
	
	@GetMapping("/failed")// localhost:8080/grade/filter/failed
	public String getFailedGrades(Model model) {
		try {
			ArrayList<Grade> selectedGrades = gradeFitlerService.selectFailedGrades();
			model.addAttribute("mydata", selectedGrades);
			model.addAttribute("msg", "Failed grades");
			return "grade-show-all-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/student/{id}")// localhost:8080/grade/filter/student/2
	public String getGradesFilterByStudentId(@PathVariable("id") int id, Model model) {
		try {
			ArrayList<Grade> selectedGrades = gradeFitlerService.selectGradesByStudentId(id);
			model.addAttribute("mydata", selectedGrades);
			model.addAttribute("msg", "student "+id+" grades");
			return "grade-show-all-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/avg/course/{id}")// localhost:8080/grade/filter/avg/course/1
	public String getAvgGradeByCourseId(@PathVariable("id") int id, Model model) {
		try {
			float avgGrade = gradeFitlerService.calculateAVGGradeInCourseId(id);
//			model.addAttribute("mydata", avgGrade);
			model.addAttribute("msg", "course "+id+" avg grade: "+avgGrade);
			return "grade-show-all-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
}
