package com.cts.ems.service;
 
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
 
import com.cts.ems.entity.Course;

import com.cts.ems.entity.Student;

import com.cts.ems.repository.CourseRepository;

import com.cts.ems.repository.StudentRepository;

@Service

public class CourseServiceImpl implements CourseService {
 
	@Autowired

	private CourseRepository courseRepository;

	@Autowired

	private StudentRepository studentRepository;

	@Override

	public void enrollIncourse(Long studentId, Long courseId) {

		Course course = courseRepository.findById(courseId).orElse(null);

		if(course != null) {		

			Student student = studentRepository.findById(studentId).get();

			student.setCourseId(courseId);

			studentRepository.save(student);

		}

	}
 
	@Override

	public List<Course> getAllCourse() {
 
		return courseRepository.findAll();

	}

 
}
