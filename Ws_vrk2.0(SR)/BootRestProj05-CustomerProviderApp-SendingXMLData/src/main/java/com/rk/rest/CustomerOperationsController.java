package com.rk.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {
	
	@GetMapping("/show")
	public Customer showData() {
		return new Customer(101,"raja","hyd",64454.0);
	}
	
	@GetMapping("/report")
	public ResponseEntity<Customer> reportData(){
		Customer cust=new Customer(102,"raja","hyd",64454.0);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
}
