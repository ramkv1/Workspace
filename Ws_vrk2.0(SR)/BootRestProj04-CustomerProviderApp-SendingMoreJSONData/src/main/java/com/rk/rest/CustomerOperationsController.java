package com.rk.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.model.Company;
import com.rk.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {
	
	//@GetMapping("/report")
	@PostMapping("/report")
	public ResponseEntity<Customer> showCustomerData(){
		Customer customer=new Customer(101,
										"raju",
										"hyd",
										90900.50,
										new String[] {"red","yellow","green"},
										List.of("king","babu","kanna"),
										Set.of(99999L,888888L,7777777L),
										Map.of("aadhar",5746794L,"voterId",989996L),
										new Company(5446,"HCL","Hyd","IT"),
										LocalDateTime.now(),
										true);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
}
