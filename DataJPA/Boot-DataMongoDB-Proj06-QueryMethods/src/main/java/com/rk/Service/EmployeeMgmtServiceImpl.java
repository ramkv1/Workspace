package com.rk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Document.Employee;
import com.rk.Repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	
	@Override
	public List<Object[]> fetchEmpsDataByAddrs(String addrs) {
		return empRepo.getEmpsDataByAddrs(addrs);
	}


	@Override
	public List<Employee> fetchempallDataByAddrs(String addrs) {
		return empRepo.getEmpsFullDataByAddrs(addrs);
	}


	@Override
	public List<Object[]> fetchempDataByAddrsandSalary(double salary, String addrs) {
		return empRepo.getEmpsDataBySalaryAndAddrs(salary, addrs);
	}


	@Override
	public List<Object> fetchEmpDataBySalaryRange(double start, Double end) {
		return empRepo.getEmpsDataBySalaryRange(end, start);
	}


	@Override
	public List<Employee> fetchEmpsFullDataByAddresses(String addres1, String addres2) {
		return empRepo.getEmpFullDataByAddresses(addres1, addres2);
	}

}
