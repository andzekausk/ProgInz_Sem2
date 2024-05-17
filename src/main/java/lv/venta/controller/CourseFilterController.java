package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Student;
import lv.venta.service.ICourseFilterService;

@Controller
@RequestMapping("/course")
public class CourseFilterController {
	
	@Autowired
	private ICourseFilterService courseFilterService;
	
	@GetMapping("/filter/creditpoints/{param}")// localhost:8080/course/filter/creditpoints/2
	public String getCourseFilterByCreditpoints(@PathVariable("param") int param, Model model) {
		try {
			ArrayList<Course> selectedCourses = courseFilterService.selectCoursesByCreditpoints(param);
			model.addAttribute("mydata", selectedCourses);
			return "course-show-all-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/filter/professor/{id}")// localhost:8080/course/filter/professor/2
	public String getCourseFilterByProfessorId(@PathVariable("id") int id, Model model) {
		try {
			Course selectedCourses = courseFilterService.selectCourseByProfessorId(id);
			model.addAttribute("mydata", selectedCourses);
			return "course-show-all-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/filter/student/{id}")// localhost:8080/course/filter/student/2
	public String getCourseFilterByStudentId(@PathVariable("id") int id, Model model) {
		try {
			ArrayList<Course> selectedCourses = courseFilterService.selectCoursesByStudentId(id);
			model.addAttribute("mydata", selectedCourses);
			return "course-show-all-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
}
