package com.cts.ems.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
 
import com.cts.ems.entity.Faculty;

import com.cts.ems.service.FacultyService;

@RestController

@RequestMapping("/api/faculty")

public class FacultyController {

	@Autowired

	private FacultyService facultyService;
 
	

	@GetMapping("/AllFaculty")

	public List<Faculty> getAllFaculty() {

		return facultyService.getAllFaculty();

	}
 
	

	@GetMapping("/{id}")

	public Faculty getFacultyById(@PathVariable Long employeeId) {

		return facultyService.getFacultyById(employeeId);

	}
 
	

	@PostMapping("/addFaculty")

	public Faculty addFaculty(@RequestBody Faculty faculty) {

		return facultyService.addFaculty(faculty);

	}
 
	@PutMapping("/{id}")

	public Faculty updateFaculty(@PathVariable Long employeeId,@RequestBody Faculty faculty) {

		return facultyService.updateFaculty(employeeId, faculty);

	}
 
	@DeleteMapping("/{id}")

	public void removeFaculty(@PathVariable Long employeeId) {

		  facultyService.removeFaculty(employeeId);

	}

}
