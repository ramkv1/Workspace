package com.rk.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IDoctorMgmtService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner{

	@Autowired
	private IDoctorMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*		System.out.println(service.deleteDoctorByIdsInBatch(Arrays.asList(52,null)));*/
		/*Doctor doctor=new Doctor();
		doctor.setSpecialization("cardio"); doctor.setIncome(90000.0);
		service.showDoctorsByExampleData(doctor, true, "income").forEach(System.out::println);
		*/
		System.out.println(service.findDoctorById(202));
	}

}
