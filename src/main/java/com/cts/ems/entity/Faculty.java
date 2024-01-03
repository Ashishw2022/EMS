package com.cts.ems.entity;
 
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Entity

@Data

public class Faculty {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long employeeId;

	private String Name;

	private String contactInformation;

	private String coursesAssigned;
 
}
