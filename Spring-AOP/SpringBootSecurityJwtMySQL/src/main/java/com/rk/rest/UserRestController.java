package com.rk.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.entity.User;
import com.rk.entity.UserRequest;
import com.rk.entity.UserResponse;
import com.rk.service.IUserService;
import com.rk.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//1. save user Data in Database
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer id=service.saveUser(user);
		String body="User '"+id+"' saved";
		return new ResponseEntity<String>(body,HttpStatus.OK);
		//return ResponseEntity.ok(body);
	}
	//2.Validate User and Generate token
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request){
		
		//Validate un/pwd with database
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		
		String token=util.generateToken(request.getUsername());
		return ResponseEntity.ok(new UserResponse(token,"Success! Generated by NIT"));
	}
	//3.After Login only
	@PostMapping("/welcome")
	public ResponseEntity<String> accessData(Principal p)
	{
		return ResponseEntity.ok("Hello User!"+p.getName());
	}
}
