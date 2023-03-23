package com.rk.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationTestController {
	
	@GetMapping("/report")
	public ResponseEntity<String> getAllEmployees(){
		System.out.println("EmployeeOperationTestController.getAllEmployee()");
		return new ResponseEntity<String>("GET-- All employee are listed",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerEmployee(){
		System.out.println("EmployeeOperationTestController.registerEmployee()");
		return new ResponseEntity<String>("POST--Employee registration",HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(){
		System.out.println("EmployeeOperationTestController.updateEmployee()");
		return new ResponseEntity<String>("PUT--Employee is updated",HttpStatus.OK);
		
	}
	
	@PatchMapping("/emailupdate")
	public ResponseEntity<String> updateEmployeeEmail(){
		System.out.println("EmployeeOperationTestController.updateEmployeeEmail()");
		return new ResponseEntity<String>("PATCH--Employee Email is Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(){
		System.out.println("EmployeeOperationTestController.deleteEmployee()");
		return new ResponseEntity<String>("delete-- Employee Email is updated",HttpStatus.OK);
	}
}
