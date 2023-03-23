package com.rk.service;

import java.util.List;

import com.rk.entity.Employee_Date_Time;

public interface IEmployeeMgmtService {
	public String saveEmployee(Employee_Date_Time dateTime);
	public List<Employee_Date_Time> getAllEmployee();
	public List<Integer> showEmployeeAgesByDesg(String desg);
}
