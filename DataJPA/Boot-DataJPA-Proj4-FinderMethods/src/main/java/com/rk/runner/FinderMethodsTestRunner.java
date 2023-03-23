package com.rk.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.entity.Doctor;
import com.rk.repository.IDoctorRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{
	
	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*doctorRepo.findByDocNameEquals("raja").forEach(System.out::println);
		doctorRepo.findByDocNameIs("raja").forEach(System.out::println);
		doctorRepo.findByDocName("raja").forEach(System.out::println);*/

		/*doctorRepo.findByIncomeBetween(50000.0,100000.0).forEach(Doc->{
			System.out.println(Doc);
		});*/
		/*doctorRepo.findBySpecialization(List.of("Cardio","Ortho")).forEach(doc->{
			System.out.println(doc);
		});;*/
		/*doctorRepo.findByDocNameLike("r%").forEach(System.out::println);
		System.out.println("___________________________________________");
		doctorRepo.findByDocNameLike("%h").forEach(System.out::println);*/
		/*	System.out.println("___________________________________________");
			doctorRepo.findByDocNameStartsWith("r").forEach(System.out::println);
			System.out.println("___________________________________________");
			doctorRepo.findByDocNameEndsWith("h").forEach(System.out::println);
			System.out.println("___________________________________________");
			doctorRepo.findByDocNameContains("a").forEach(System.out::println);
		*/
		System.out.println("---------------------------");
		Iterable<Doctor> it=doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(50000.0, 200000.0);
		it.forEach(System.out::println);
		
		System.out.println("_________________________");
		doctorRepo.findBySpecializationOrIncomeBetween(List.of("cardio","physicain"), 3000.0, 7000.0).forEach(System.out::println);
		
		}
}
