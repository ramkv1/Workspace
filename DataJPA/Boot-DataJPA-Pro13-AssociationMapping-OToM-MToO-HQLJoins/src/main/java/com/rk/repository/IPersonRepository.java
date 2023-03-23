package com.rk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
	
	
	@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provide from Person p inner join p.contactDetails ph")
	public List<Object[]> getDataUsingJoins();
}
