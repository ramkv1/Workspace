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
	
	@PostMapping("/registor")
	public ResponseEntity<Customer> register(@RequestBody Customer customer){
		return new ResponseEntity<Customer> (customer,HttpStatus.CREATED);
	}
}
