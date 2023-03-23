package com.rk.service;

import java.util.List;

import com.rk.document.Employee;

public interface IEmployeeMgmtService {
	public String SaveDocuments(Employee emp);
	public Iterable<Employee> findAllEmployee();
	public Employee findEmployeeById(Integer id);
	
	public List<Employee> fetchEmployeeBySalaryRange(double start,double end);
	public Employee fetchEmployeeByName(String name);
}
