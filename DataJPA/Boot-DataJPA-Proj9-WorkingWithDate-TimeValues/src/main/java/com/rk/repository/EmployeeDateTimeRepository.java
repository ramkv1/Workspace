package com.rk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer> {

	@Query(nativeQuery = true,value = "SELECT YEAR(CURRENT_TIMESTAMP)-YEAR(dob) FROM employee_date_time WHERE desg=:job")
	public List<Integer> getEmployeeAgeByDesg(String job);
}
