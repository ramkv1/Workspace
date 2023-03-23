package com.rk.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Doctor;
import com.rk.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService{

	@Autowired
	private IDoctorRepository doctoRepo;

	@Override
	public List<Doctor> searchDoctorBySpecialization(String sp1, String sp2) {
		//use repo
		List<Doctor> list=doctoRepo.searchDoctorBySpecialization(sp1, sp2);
		return list;
	}

	@Override
	public List<Object[]> showDoctorDataByIncome(double start, double end) {
		List<Object[]> list=doctoRepo.searchDoctorDataByIncome(start, end);
		return list;
	}

	@Override
	public List<String> showDoctorsDataByIncomeRange(double min, double max) {
		List<String> list=doctoRepo.searchAllDoctorsDataByIncomeRange(min, max);
		return list;
	}

	@Override
	public Doctor searchDoctorInfoByName(String docName) {
		Doctor doc=doctoRepo.showDoctorInfoByName(docName).orElseThrow(()->new IllegalArgumentException("Doctor Not Found"));
		return doc;		
	}

	@Override
	public Object searchDoctorDataByName(String docName) {
		Object obj=doctoRepo.showDoctorDataByName(docName);
		return obj;
	}

	@Override
	public String searchSpecializationByName(String docName) {
		String result=doctoRepo.showSpecializationByName(docName);
		return result;
	}

	@Override
	public int showDoctorNamesCount() {
		int count=doctoRepo.fetchDoctorNameCount();
		return count;
	}

	@Override
	public Object showAggregateData() {
		Object obj=doctoRepo.fetchAggregateData();
		return obj;
	}

	@Override
	public int appraiseDoctorIncomeBySpecialization(String specialization, double hikePercentage) {
		int count=doctoRepo.hikeDoctorsIncomeBySpecialization(specialization, hikePercentage);
		return count;
	}

	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		return doctoRepo.removeDoctorByIncomeRange(start, end);
	}

	@Override
	public String showSystemDate() {
		return doctoRepo.showSystemDate();
		
	}

	

	/*@Override
	public List<Doctor> showDoctorByIncomeRange(double startRange, double endRange) {
		return doctoRepo.searchDoctorByIncomeRange(startRange, endRange);
	}*/

}