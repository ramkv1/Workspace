package com.rk.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationController {
	
	
	
	@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage(){
		return new ResponseEntity<String>("Good Morning1",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> showWishMessage(@PathVariable Integer id,@PathVariable String name){
		return new ResponseEntity<String>("Good Morning::"+id+"............"+name,HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registorActor(@RequestBody Actor actor){
		return new ResponseEntity<String>(actor.toString(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/wish/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable Integer id){
		return new ResponseEntity<String>(id+" Actro is Deleted",HttpStatus.OK);
	}
	
	
	@GetMapping("/report/{id}")
	public ResponseEntity<Actor> showActorById(@PathVariable Integer id){
		Actor actor=new Actor();
		actor.setActorId(id);
		actor.setActorName("raja");
		actor.setActorAddrs("Hyd");
		actor.setRemuneration(85566.0);
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}

}
