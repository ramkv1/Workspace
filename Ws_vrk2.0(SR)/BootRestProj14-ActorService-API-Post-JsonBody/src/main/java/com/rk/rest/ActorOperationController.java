package com.rk.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationController {
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registorActor(@RequestBody Actor actor){
		return new ResponseEntity<String>(actor.toString(),HttpStatus.CREATED);
	}



}
