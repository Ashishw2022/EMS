package com.cts.ems.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.cts.ems.entity.Faculty;
import com.cts.ems.repository.FacultyRepository;
 
import jakarta.persistence.EntityNotFoundException;
@Service
 
public class FacultyServiceImpl implements FacultyService {
 
	@Autowired
	private FacultyRepository facultyRepository;
	@Override
	public List<Faculty> getAllFaculty() {
		return facultyRepository.findAll();
	}
 
	@Override
	public Faculty getFacultyById(Long employeeId) {
		return facultyRepository.findById(employeeId).orElseThrow(()->new EntityNotFoundException("Faculty Not found"));
	}
 
	@Override
	public Faculty addFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
 
	@Override
	public Faculty updateFaculty(Long employeeId, Faculty updatedFaculty) {
		Faculty existingFaculty=getFacultyById(employeeId);
		existingFaculty.setEmployeeId(updatedFaculty.getEmployeeId());
		existingFaculty.setName(updatedFaculty.getName());
		existingFaculty.setContactInformation(updatedFaculty.getContactInformation());
		existingFaculty.setCoursesAssigned(updatedFaculty.getCoursesAssigned());
 
		return null;
	}
 
	@Override
	public void removeFaculty(Long employeeId) {
		facultyRepository.deleteById(employeeId);
	}
 
	
}