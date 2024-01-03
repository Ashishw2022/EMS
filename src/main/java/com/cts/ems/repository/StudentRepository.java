package com.cts.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ems.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByUserName(String userName);

}
