package com.rk.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@RefreshScope
public class EmployeeOperationsController {
	@Value("${dbuser}")
	private String user;
	@Value("${dbpwd}")
	private String pwd;
	
	@GetMapping("/display")
	public ResponseEntity<String> showData(){
		return new ResponseEntity<String>("Db Properties from Git Account are::"+user+"-------"+pwd,HttpStatus.OK);
	}
}
