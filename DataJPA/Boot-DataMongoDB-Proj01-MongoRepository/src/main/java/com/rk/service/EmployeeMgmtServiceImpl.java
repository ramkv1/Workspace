package com.rk.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rk.Repository.IEmployeeRepository;
import com.rk.document.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String SaveDocuments(Employee emp) {
		String idVal=empRepo.insert(emp).getId();
		return "employee is Saved with id value:"+idVal;
	}

	@Override
	public Iterable<Employee> findAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(String id) {
		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
	}

	@Override
	public String modifyEmployeeWithNewSalary(String id, float hikePercentage) {
		//find Employee by id
		Optional<Employee> opt=empRepo.findById(id);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			emp.setSalary(emp.getSalary()+(emp.getSalary()*hikePercentage/100));
			String idval=empRepo.save(emp).getId();
			return idval+"Document is Updated";
		}
		return id+"document is not Found";
	}

	@Override
	public String RemoveEmployee(String id) {
		//find Employee by id
		Optional<Employee> opt=empRepo.findById(id);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			empRepo.delete(emp);
			return id+"::id Document is Deleted";
		}
		else {
			return (id+"::Document is not Deleted");
		}
	}

	@Override
	public List<Employee> searchEmployeeByExampleData(Employee emp, boolean asc, String... props) {
		Example<Employee> example=Example.of(emp);
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		List<Employee> list=empRepo.findAll(example,sort);
		return list;
	}

	@Override
	public String registerEmployee(Employee employee) {
		String id=UUID.randomUUID().toString();
		System.out.println(id);
		employee.setId(id);
		String idval=empRepo.insert(employee).getId();
		return "Employee doc is saved with id value::"+idval;
	}
	
}
