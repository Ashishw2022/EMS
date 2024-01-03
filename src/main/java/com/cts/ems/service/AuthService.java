package com.cts.ems.service;

import com.cts.ems.dto.UserDTO;
import com.cts.ems.entity.Student;

public interface AuthService {
	UserDTO createUser(Student user);

}
