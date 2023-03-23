package com.rk.repository;

import org.springframework.data.repository.CrudRepository;

import com.rk.entity.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer>{

}
