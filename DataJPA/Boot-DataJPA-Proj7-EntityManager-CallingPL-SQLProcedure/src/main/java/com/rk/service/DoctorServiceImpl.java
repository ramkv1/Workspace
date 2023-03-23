package com.rk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("doctorService")
public class DoctorServiceImpl implements IDoctorManagementService{

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Doctor> showDoctorByIncomeRange(double start, double end) {
		//Create StoredProcedureQuery Object PL?SQL Procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME_RANGE",Doctor.class);
		//register both IN,OUT params by specifying their mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		//set values to In params
		query.setParameter(1, start);
		query.setParameter(2, end);
		//call PL?SQL procedures
		List<Doctor> list=query.getResultList();
		return list;

	}

}
