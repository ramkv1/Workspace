package com.rk.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationController {
	
	/*@GetMapping("/report/{sno}/{name}")
	public String getReportData(@PathVariable("sno") int no,@PathVariable String name) {
		return no+"===================>"+name;
	}*/
	/*@GetMapping("/report/{sno}/{sname}")
	public String getReportData1() {
		return "Data1";
	}
	
	@GetMapping("/report/sno/sname")
	public String getReportData2() {
		return "Data2";
	}
	
	@GetMapping("/report/{sno}/sname")
	public String getReportData3() {
		return "Data3";
	}
	@GetMapping("/report/sno/{sname}")
	public String getReportData4() {
		return "Data4";
	}*/
	@GetMapping("/report/{sno}/{sname}")
	public String getReportData1() {
		return "data1";
	}
	@GetMapping("/report/101/raja")//==========>More Static
	public String getReportData2() {
		return "Data2";
	}
	
}
