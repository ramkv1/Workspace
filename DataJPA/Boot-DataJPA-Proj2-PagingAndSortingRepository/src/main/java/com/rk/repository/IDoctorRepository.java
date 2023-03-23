package com.rk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rk.entity.Doctor;

public interface IDoctorRepository extends PagingAndSortingRepository<Doctor, Integer>,CrudRepository<Doctor, Integer>{

}
