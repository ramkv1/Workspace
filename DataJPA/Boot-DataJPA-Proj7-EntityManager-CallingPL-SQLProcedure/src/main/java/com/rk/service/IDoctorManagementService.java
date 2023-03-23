package com.rk.service;

import java.util.List;

import com.rk.entity.Doctor;

public interface IDoctorManagementService {
	public List<Doctor> showDoctorByIncomeRange(double start,double end);
}
