package com.rk.service;

import java.util.List;

import com.rk.entity.EMPLOYEE_INFO;

public interface IDoctorManagementService {
	public List<EMPLOYEE_INFO> showDoctorByIncomeRange(double start,double end);
}
