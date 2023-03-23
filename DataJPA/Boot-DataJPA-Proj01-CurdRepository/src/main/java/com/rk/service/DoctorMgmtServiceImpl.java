package com.rk.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Doctor;
import com.rk.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println(doctorRepo.getClass()+"-------"+Arrays.toString(doctorRepo.getClass().getDeclaredMethods()));
		Doctor doc=doctorRepo.save(doctor);
		return "Doctor obj is saved with id value::"+doc.getDocId();
	}

	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctor) {
		if(doctor!=null) {
			Iterable<Doctor> savedDoctor=doctorRepo.saveAll(doctor);
			int size=((Collection)savedDoctor).size();
			List<Integer> ids=(List<Integer>) ((Collection) savedDoctor).stream().map(d->((Doctor) d).getDocId()).collect(Collectors.toList());
			return size+" No.of Doctors are saved with id values::"+ids.toString();
		}
		else {
			throw new IllegalArgumentException("Invalid Doctor Info");
		}
	}

	@Override
	public long fetchDoctorCount() {
		
		return doctorRepo.count();
	}

	@Override
	public Boolean checkDoctorAvailbility(Integer id) {
		return doctorRepo.existsById(id);
	}

	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllDoctorByIds(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}

	
	/*	@Override
		public Doctor showDoctorById(Integer id) {
			Optional<Doctor> opt=doctorRepo.findById(id);
			if(opt.isPresent())
				return opt.get();
			else
				throw new IllegalArgumentException("Invalid Doctor ID");
		}*/
	///We can wrote above method in single Line
	/*@Override
	public Doctor showDoctorById(Integer id) {
		Doctor doctor=doctorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Doctor ID"));
		return doctor;
	}*/
	@Override
	public Doctor showDoctorById(Integer id) {
		Doctor dutyDoctor=new Doctor();
		dutyDoctor.setSpecialization("duty Doctor");
		Doctor doctor=doctorRepo.findById(id).orElse(dutyDoctor);
		return doctor;
	}

	@Override
	public String updateDoctorIncomeById(Integer id, float hikePercentage) {
		//load Object
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) {
			Doctor doctor=opt.get();
			double newIncome=doctor.getIncome()+(doctor.getIncome()*(hikePercentage/100.0f));
			//set new income to the Object
			doctor.setIncome(newIncome);
			//partially update the object
			return doctorRepo.save(doctor).getDocId()+"is Updated with::::"+newIncome;
		}
		else {
			return id+"doctor not fount";
		}
	}

	@Override
	public String registerOrUpdateDoctor(Doctor doctor) {
		//load Doctor object
		Optional<Doctor> opt=doctorRepo.findById(doctor.getDocId());
		if(opt.isPresent()) {
			doctorRepo.save(doctor);
			return doctor.getDocId()+"Doctor Details are found and Updated::";
		}
		else {
			return "Doctor is Saved with id value ::"+doctorRepo.save(doctor).getDocId();
		}
	}

	@Override
	public String deleteDoctorById(Integer id) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id+"::Doctor is Deleted";
		}
		else {
			return id+" Doctor Not Found for Deletion";
		}
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		//Load Object
		Optional<Doctor> opt=doctorRepo.findById(doctor.getDocId());
		if(opt.isEmpty()) {
			return doctor.getDocId()+"::Doctor is not found";
		}
 		else {
 			doctorRepo.delete(opt.get());
 			return doctor.getDocId()+"::Doctor is found and Deleted";
 		}
	}
}
