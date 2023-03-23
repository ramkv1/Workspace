package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IDoctorMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner{

	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*			service.showDoctorByIncomeRange(20000.0,300000.0).forEach(System.out::println);
		*/		
		/*service.searchDoctorBySpecialization("General", "cardio").forEach(System.out::println);
		System.out.println("______________________________");
		service.showDoctorDataByIncome(20000.0, 200000.0).forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+"   ");
			}
			System.out.println();
		});
		System.out.println("___________________________________");
		service.showDoctorDataByIncome(20000.0, 200000.0).forEach(row->{
			System.out.println(Arrays.toString(row));
		});
		
		
		System.out.println("____________________________________");
		service.showDoctorsDataByIncomeRange(40000.0, 500000.0).forEach(System.out::println);
		
		System.out.println("------------------------------------------------");
		Doctor doctor=service.searchDoctorInfoByName("raja");
		System.out.println("Doctor Details are===========>"+doctor);
		System.out.println();
		
		System.out.println("---------------------------");
		Object obj=service.searchDoctorDataByName("raja");
		Object data[]=(Object[]) obj;
		for(Object o:data) {count
			System.out.println(0+"  ");
		}
		System.out.println();
		System.out.println("Result is::"+Arrays.toString(data));
		String result=service.searchSpecializationByName("raja");
		System.out.println("specialization is::"+result);
		*/	
		/*	
			System.out.println("Unique doctor names count::"+service.showDoctorNamesCount());
			System.out.println("_________________________________");
			Object[] results=(Object[]) service.showAggregateData();
			System.out.println("records count::"+results[0]);
			System.out.println("max income value::"+results[1]);
			System.out.println("min income value::"+results[2]);
			System.out.println("sum of income::"+results[3]);
			System.out.println("Avg of income::"+results[4]);*/
		
		System.out.println("__________________non-select operation------------");
		/*int count=service.appraiseDoctorIncomeBySpecialization("cardio", 10.0);
		System.out.println("no.of Records that are effected::"+count);
		*/
		
		
		//System.out.println("deleted doctors count::"+service.fireDoctorsByIncomeRange(100000.0, 110000.0));
	
		System.out.println("System date time::"+service.showSystemDate());
	}

}
