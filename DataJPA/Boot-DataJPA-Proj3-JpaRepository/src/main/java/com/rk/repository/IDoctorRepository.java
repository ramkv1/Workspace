package com.rk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{

}
