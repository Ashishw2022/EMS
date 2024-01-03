package com.cts.ems.entity;
import java.util.Date;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "student")
@Data
public class Student {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
 
	private String userName;
 
	private String password;
	private String Name;
	private String Address;
	private String State;
	private String Country;
	private String Email;
	private Long contactNo;
	private Date dateOfBirth;
	private String programOfStudy;
	private Long courseId;
 
}