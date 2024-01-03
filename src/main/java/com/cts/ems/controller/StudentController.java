
package com.cts.ems.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ems.dto.AuthenticationResponse;
import com.cts.ems.dto.UserDTO;
import com.cts.ems.entity.Student;
import com.cts.ems.service.AuthService;
import com.cts.ems.service.UserDetailsServiceImpl;
import com.cts.ems.util.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController

public class StudentController {

	@Autowired

	private AuthService authService;

	@Autowired

	private JwtUtil jwtUtil;

	@Autowired

	private AuthenticationManager authenticationManager;

	@Autowired

	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/register")

	public ResponseEntity<?> signupUser(@RequestBody Student user) {

		UserDTO createdUser = authService.createUser(user);

		if (createdUser == null) {

			return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

	}

	@GetMapping("/login")

	public AuthenticationResponse createAuthenticationToken(@RequestHeader String userName,
			@RequestHeader String password, HttpServletResponse response)
			throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

		} catch (BadCredentialsException e) {

			throw new BadCredentialsException("Incorrect username or password!");

		} catch (DisabledException disabledException) {

			response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");

			return null;

		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

		final String jwt = jwtUtil.generateToken(userDetails.getUsername());

		return new AuthenticationResponse(jwt);

	}

	
}