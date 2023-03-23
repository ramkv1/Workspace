package com.rk.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String ... props) {
		// prepare the sort Object
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		//Use Repo
		Iterable<Doctor> it=doctoRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props) {
		//prepare the sort Object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		//prepre pageable Object
		Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		//use repo
		Page<Doctor> page=doctoRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDataThroughPagination(int pageSize) {
		//decide the no.of pages
		long count=doctoRepo.count();
		long pagesCount=count/pageSize;
		
		if(count%pagesCount!=0)
			pagesCount++;
		
		for(int i=0;i<pagesCount;i++) {
			//create pageable Object
			Pageable pageable=PageRequest.of(i, pageSize);
			//get each page record
			Page<Doctor> page=doctoRepo.findAll(pageable);
			System.out.println("page ::"+(page.getNumber()+1)+"records of"+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("_________________________________");
			
		}
	}
	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		//load the entities
		List<Doctor> list=(List<Doctor>) doctoRepo.findAllById(ids);
		//Delete the entities
		doctoRepo.deleteAllById(ids);
		return null;
	}

}
