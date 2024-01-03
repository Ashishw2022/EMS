package com.cts.ems.service;
 
import java.util.List;
 
 
import com.cts.ems.entity.Faculty;
 
public interface FacultyService {
 
	List<Faculty> getAllFaculty();
	Faculty getFacultyById( Long employeeId);
	Faculty addFaculty( Faculty faculty);
	Faculty updateFaculty(Long employeeId,Faculty faculty);
	void removeFaculty(Long employeeId);

 
}