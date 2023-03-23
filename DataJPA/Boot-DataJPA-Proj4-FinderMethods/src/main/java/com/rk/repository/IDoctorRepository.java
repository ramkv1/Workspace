package com.rk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	//On Entity Queries(Selects all columns of the db table)
	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocNameEquals(String docName);
	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocNameIs(String docName);
	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocName(String docName);

	//SELECT * FROM JPA_DOCTOR_INFO WHERE INCOME BETWEEN ? AND ?
	public Iterable<Doctor> findByIncomeBetween(Double start,Double end);
	//SELECT * FROM JPA_DOCTOR_INFO WHERE SPECIALIZATION IN(?,?,?)
	/*	public Iterable<Doctor> findBySpecialization(List<String> list);*/	
	
	//SELECT * FROM JPA_DOCTOR_INFO WHERE 
	public Iterable<Doctor> findByDocNameLike(String cond);
	
	public Iterable<Doctor> findByDocNameStartsWith(String startLetter);
	public Iterable<Doctor> findByDocNameEndsWith(String endLetter);
	public Iterable<Doctor> findByDocNameContains(String letters);
	
	/*---------------------------------------------------------------------------------*/
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange,double endRange);
	public Iterable<Doctor> findBySpecializationOrIncomeBetween(List<String> specials,double start,double end);

}
