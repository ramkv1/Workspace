package com.rk.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {
	
	@PostMapping("/save")
	public ResponseEntity<Customer> savecustomer(@RequestBody Customer cust){
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
}
