package com.rk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Repository.IEmployeeRepository;
import com.rk.document.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String SaveDocuments(Employee emp) {
		int idVal=empRepo.insert(emp).getEno();
		return "employee is saved with id value::"+idVal;
	}

	@Override
	public Iterable<Employee> findAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public List<Employee> fetchEmployeeBySalaryRange(double start, double end) {
		return empRepo.findBySalaryBetween(start, end);
	}

	@Override
	public Employee fetchEmployeeByName(String name) {
		return empRepo.findByEname(name);
	}


	
}
