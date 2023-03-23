package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IDoctorManagementService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {

	@Autowired
	private IDoctorManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
		//Invoke the b.method of service
		service.showDoctorByIncomeRange(10000.0, 200000.0).forEach(System.out::println);
	}

}
