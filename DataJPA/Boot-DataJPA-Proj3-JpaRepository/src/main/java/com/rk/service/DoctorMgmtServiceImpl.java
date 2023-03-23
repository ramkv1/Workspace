package com.rk.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rk.entity.Doctor;
import com.rk.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService{

	@Autowired
	private IDoctorRepository doctoRepo;

	@Override
	public String deleteDoctorByIdsInBatch(List<Integer> ids) {
		//load the entites
		List<Doctor> list=doctoRepo.findAllById(ids);
		//delete the entities
		doctoRepo.deleteAllByIdInBatch(ids);
		
		return list.size()+" Records are deleted";
	}

	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties) {
		//prepair sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		//example object
		Example example=Example.of(exDoctor);
		//use the repo
		List<Doctor> list=doctoRepo.findAll(example,sort);
		//return the collection
		return list;
	}

	@Override
	public Doctor findDoctorById(Integer id) {
		Doctor doctor=doctoRepo.getReferenceById(id);
		return doctor;
	}
	
}
