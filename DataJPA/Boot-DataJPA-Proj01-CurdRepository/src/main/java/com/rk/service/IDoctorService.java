package com.rk.service;

import javax.print.Doc;

import com.rk.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public String registerGroupOfDoctors(Iterable<Doctor> doctor);
	public long fetchDoctorCount();
	public Boolean checkDoctorAvailbility(Integer id);
	public Iterable<Doctor> showAllDoctors();
	public Iterable<Doctor> showAllDoctorByIds(Iterable<Integer> ids);
	public Doctor showDoctorById(Integer id);
	public String updateDoctorIncomeById(Integer id,float hikePercentage);
	public String registerOrUpdateDoctor(Doctor doctor);
	public String deleteDoctorById(Integer id);
	public String deleteDoctor(Doctor doctor);
}
