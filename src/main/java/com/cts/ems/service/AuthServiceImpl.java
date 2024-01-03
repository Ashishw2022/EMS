package com.cts.ems.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.ems.dto.UserDTO;
import com.cts.ems.entity.Student;
import com.cts.ems.repository.StudentRepository;
 
@Service
public class AuthServiceImpl implements AuthService {
 
    @Autowired
    private StudentRepository userRepository;
    @Override
    public UserDTO createUser(Student user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Student createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setStudentId(createdUser.getStudentId());
        userDTO.setUserName(createdUser.getUserName());
        return userDTO;
    }
	
}