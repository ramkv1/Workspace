package com.rk.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class WishMessageController {
	
	@GetMapping("/display")
	public ResponseEntity<String> generateWishMessage(){
		//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current hour of the day
		int hour=ldt.getHour();
		String msg=null;
		if(hour<12)
			msg="Good Morning";
		else if (hour<16)
			msg="Good Afternoon";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good Night";
		
		//return ResponseEntity Object
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
