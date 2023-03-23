package com.rk.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/tickets")
public class TicketBookingOperationController {
	
	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod = "dummyMethod")
	public ResponseEntity<String> bookTickets(){
		System.out.println("TicketBookingOperationController.bookTickets()");
		if(new Random().nextInt(10)<5)
			throw new RuntimeException("Problem in ticket Booking");
		
		return new ResponseEntity<String>("Book the tickets.....!",HttpStatus.OK);
	}
	public ResponseEntity<String> dummyMethod() {
		System.out.println("TicketBookingOperationController.dummyMethod()");
		return new ResponseEntity<String>("Please try later...Some problem in TicketBooking Operation",HttpStatus.OK);
		
	}
}
