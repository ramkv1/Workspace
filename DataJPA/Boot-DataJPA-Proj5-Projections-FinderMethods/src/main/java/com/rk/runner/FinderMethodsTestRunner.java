package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.repository.IDoctorRepository;
import com.rk.view.IResultView1;
import com.rk.view.IResultView2;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{
	
	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*	
			System.out.println("Repository Interface,In memory proxy class name::"+doctorRepo.getClass());
			Iterable<IResultView> it=doctorRepo.findBySpecializationIn(List.of("MD-Cardio"));
			it.forEach(doc->{
				System.out.println(getClass());
				//head "doc" represents in In memory proxy classs implementing iResultview
				System.out.println(doc.getDocName()+"---------"+doc.getIncome());
			});*/
		
		System.out.println("________________");
		Iterable<IResultView1> it1=doctorRepo.findByIncomeBetween(50000.0,200000.0,IResultView1.class);
		it1.forEach(data->{
			System.out.println(data.getDocName()+"........."+data.getSpecialization());
		});
		System.out.println("________________");
		Iterable<IResultView2> it2=doctorRepo.findByIncomeBetween(50000.0,200000.0,IResultView2.class);
		it2.forEach(data->{
			System.out.println(data.getDocName()+"........."+data.getSpecialization()+"------"+data.getIncome());
		});
	}
}
