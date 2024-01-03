package com.cts.ems.service;
 
import java.util.ArrayList;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.cts.ems.entity.Student;
import com.cts.ems.repository.StudentRepository;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private StudentRepository userRepository;
 
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
 
        Optional<Student> user = Optional.of(userRepository.findByUserName(userName));
        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), new ArrayList<>());
    }
}