package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IEmployeeMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner{

	
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			/*//save the object
			Employee_Date_Time emp=new Employee_Date_Time(
					"raja",
					"Managar",
					LocalDateTime.of(1990,10,20,11,24),
					LocalTime.of(17, 45),
					LocalDate.of(2020, 10, 30)	
					);
			String result=service.saveEmployee(emp);
			System.out.println(result);
			*/		
		service.getAllEmployee().forEach(System.out::println);	
		
		System.out.println("==========================================");
		service.showEmployeeAgesByDesg("Managar").forEach(System.out::println);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
