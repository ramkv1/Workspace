package com.rk.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rk.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String>{

}
