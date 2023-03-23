package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.entity.Doctor;
import com.rk.service.IDoctorService;

@SpringBootApplication
public class BootDataJpaProj01CurdRepositoryApplication {

	public static void main(String[] args) {

		// get Ioc container
		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj01CurdRepositoryApplication.class, args);
		// get service class Object
		IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);

		/*try {
			// create Doctor class object
			Doctor doctor = new Doctor();
			doctor.setDocName("Suresh2");
			doctor.setSpecialization("General");
			doctor.setIncome(98000.0);
			// Invoke the b.method
			String resultMsg = service.registerDoctor(doctor);
			System.out.println(resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//==========================
		/*try {
			//Doctor 1 Info
			Doctor doc1=new Doctor();
			doc1.setDocName("rajesh1");
			doc1.setIncome(80000.0);
			doc1.setSpecialization("Cardio");
			//Doctor 2 Info
			Doctor doc2=new Doctor();
			doc2.setDocName("Rahul1");
			doc2.setIncome(70000.0);
			doc2.setSpecialization("Ortho");
			//Doctor 3 Info
			Doctor doc3=new Doctor();
			doc3.setDocName("Prasad1");
			doc3.setIncome(59000.0);
			doc3.setSpecialization("Cardio");
			 String msg=service.registerGroupOfDoctors(List.of(doc1,doc2,doc3));
			String msg=service.registerGroupOfDoctors(Arrays.asList(doc1,doc2,doc3));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		//===============
		/*	try {
				System.out.println("Count of records::"+service.fetchDoctorCount());
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			System.out.println("101 Id Doctor Exists or not::"+service.checkDoctorAvailbility(102));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		/*try {
			Iterable<Doctor> it=service.showAllDoctors();
			it.forEach(doc->{
				System.out.println(doc);
			});
			System.out.println("______________");
			it.forEach(doc->System.out.println(doc));
			System.out.println("_________________");
			it.forEach(System.out::println);
			System.out.println("_______________");
			for(Doctor doc:it) {
				System.out.println(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}*/
		/*	try {
				service.showAllDoctorByIds(List.of(1,2,52,102,152,154,202)).forEach(System.out::println);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		//==========================
		/*try {
			Doctor doctor=service.showDoctorById(102);
			System.out.println(doctor);
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}*/
		//======================
		/*try {
			System.out.println("101 Doctor info::"+service.showDoctorById(102));
			System.out.println(service.updateDoctorIncomeById(102, 10));
			System.out.println("101 Doctor info::"+service.showDoctorById(102));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		/*	try {
				Doctor doctor=new Doctor();
				doctor.setDocId(101);
				doctor.setDocName("Karan");
				doctor.setIncome(90000.0);
				doctor.setSpecialization("cardio");
				System.out.println(service.registerOrUpdateDoctor(doctor));
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		/*	try {
				System.out.println(service.deleteDoctorById(102));
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		try {
			Doctor doctor=new Doctor();
			doctor.setDocId(12);
			doctor.setDocName("karan");
			System.out.println(service.deleteDoctor(doctor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// close the IOC Container
		((ConfigurableApplicationContext) ctx).close();

	}

}
