package com.cts.ems.service;

import java.util.List;

import com.cts.ems.entity.Course;

public interface CourseService {

	void enrollIncourse(Long studentId,Long courseId);
	List<Course>getAllCourse();
}
