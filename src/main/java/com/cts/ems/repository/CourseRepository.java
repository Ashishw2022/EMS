package com.cts.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ems.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
