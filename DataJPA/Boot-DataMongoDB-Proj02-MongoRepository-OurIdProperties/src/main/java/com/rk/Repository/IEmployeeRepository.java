package com.rk.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rk.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, Integer>{
	public List<Employee> findBySalaryBetween(double start,double end);
	public Employee findByEname(String name);
}
