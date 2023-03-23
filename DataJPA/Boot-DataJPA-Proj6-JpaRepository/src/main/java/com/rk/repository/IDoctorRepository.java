package com.rk.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rk.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{

	//@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM com.rk.entity.Doctor WHERE income>=?1 AND income<=?2")
	/*@Query("FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	public List<Doctor> searchDoctorByIncomeRange(Double startRange,Double endRange);
	*/
	/*@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> searchDoctorByIncomeRange(@Param("start") Double startRange,@Param("end") Double endRange);
	*/
	
	//----------------Select--entity  query--------
	@Query("FROM Doctor WHERE specialization IN(:sp1,:sp2) ORDER BY specialization")
	public List<Doctor> searchDoctorBySpecialization(String sp1,String sp2);
	
	//---------Select--Projection Query with specific multiple col Values-----------------
	@Query("SELECT docId,docName,income FROM Doctor WHERE income between :start and :end")
	public List<Object[]> searchDoctorDataByIncome(double start,double end);
	
	//---------Select--Projection Query with specific single col Values-----------------
	@Query("SELECT docName FROM Doctor WHERE income between :min and :max")
	public List<String> searchAllDoctorsDataByIncomeRange(double min,double max);

	//------Entity Query giving single Record-----------------
	@Query("FROM Doctor where docName=:name")
	public Optional<Doctor> showDoctorInfoByName(String name);

	//--------------------Scalar Query giving single record--------
	@Query("SELECT docId,docName FROM Doctor WHERE docName=:name")
	public Object showDoctorDataByName(String name);

	//----------Scalar Query giving single record single col Value-----------
	@Query("SELECT specialization FROM Doctor where docName=:name")
	public  String showSpecializationByName(String name);
	
	
	
	////---------------------
	@Query("SELECT count(distinct docName) FROM Doctor")
	public int fetchDoctorNameCount();
	@Query("SELECT count(*),max(income),min(income),avg(income),sum(income) from Doctor")
	public Object fetchAggregateData();
	
	
	//-----------Non-Select Operations using HQL/JPQL-------------
	@Query("update Doctor SET income=income+(income*:percentage/100.0) WHERE specialization=:sp")
	@Modifying
	@Transactional
	public int hikeDoctorsIncomeBySpecialization(String sp,double percentage);
	
	@Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")
	@Modifying
	@Transactional
	public int removeDoctorByIncomeRange(double start,double end);
	
	//------------------Native SQL Queries-----------
	@Query(value = "INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL,:name,:income,:special)",nativeQuery =true )
	@Modifying
	@Transactional
	public int registorDoctor(String name,String special,double income);
	
	
	@Query(value = "SELECT NOW()",nativeQuery = true)
	public String showSystemDate();
	
	
	


}
