package com.rk.service;

import java.util.List;

import com.rk.entity.Doctor;

public interface IDoctorMgmtService {
//	public List<Doctor> showDoctorByIncomeRange(double startRange,double endRange);  	
	public List<Doctor> searchDoctorBySpecialization(String sp1,String sp2);
	public List<Object[]> showDoctorDataByIncome(double start,double end);
	public List<String> showDoctorsDataByIncomeRange(double min,double max);
	
//=====================================================
	public Doctor searchDoctorInfoByName(String docName);
	public Object searchDoctorDataByName(String docName);
	public String searchSpecializationByName(String docName);
	
//===========================================================
	public int showDoctorNamesCount();
	
	public Object showAggregateData();
	
//===============================================
	public int appraiseDoctorIncomeBySpecialization(String specialization,double hikePercentage);
	
	public int fireDoctorsByIncomeRange(double start,double end);

//=============================================
	public String showSystemDate();

}
