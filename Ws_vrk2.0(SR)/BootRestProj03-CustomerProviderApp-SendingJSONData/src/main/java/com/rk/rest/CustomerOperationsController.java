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
	public ResponseEntity<Customer> showCustomerData(){
		Customer customer=new Customer(101,"raju","hyd",90900.50);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
}
