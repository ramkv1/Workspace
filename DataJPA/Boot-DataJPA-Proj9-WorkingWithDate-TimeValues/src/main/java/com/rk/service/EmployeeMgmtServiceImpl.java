package com.rk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Employee_Date_Time;
import com.rk.repository.EmployeeDateTimeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EmployeeDateTimeRepository empRepo;
	
	@Override
	public String saveEmployee(Employee_Date_Time dateTime) {
		int idval=empRepo.save(dateTime).getEno();
		return "Employee Object is saved with the id value::"+idval;
	}

	@Override
	public List<Employee_Date_Time> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public List<Integer> showEmployeeAgesByDesg(String desg) {
		return empRepo.getEmployeeAgeByDesg(desg);
	}

}
