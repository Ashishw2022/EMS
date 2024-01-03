package com.cts.ems.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.cts.ems.entity.Course;
import com.cts.ems.service.CourseService;
 
@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
 
	@GetMapping("/enroll")
	public void enrollInCourse(@RequestHeader Long studentId, @RequestHeader Long courseId) {
		courseService.enrollIncourse(studentId, courseId);
	}
 
	@GetMapping("/all")
	public List<Course> getAllCourses() {
		return courseService.getAllCourse();
	}
 
}