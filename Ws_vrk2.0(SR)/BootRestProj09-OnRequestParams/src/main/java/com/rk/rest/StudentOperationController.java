package com.rk.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationController {
	
	@GetMapping("/report")
	public String getReportData(@RequestParam("cno") int no,@RequestParam(name = "cname",required = false) String name) {
		return no+"===================>"+name;
	}
}
