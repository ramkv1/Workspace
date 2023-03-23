package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IDoctorMgmtService;

@Component
public class PandSRepoTestRunner implements CommandLineRunner{

	@Autowired
	private IDoctorMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*service.showDoctorBySorting(false, "docName").forEach(System.out::println);
		System.out.println("________________________________");
		service.showDoctorBySorting(false, "income","docName").forEach(System.out::println);
		*/
		System.out.println("_______________________________");
		service.showDataThroughPagination(3);
	}

}
