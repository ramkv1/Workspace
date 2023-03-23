package com.rk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.Doctor;
import com.rk.view.IResultView;
import com.rk.view.IResultView1;
import com.rk.view.IView;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	
	public Iterable<IResultView> findBySpecializationIn(List<String> specials);

	public<T extends IView> Iterable<T> findByIncomeBetween(Double start,double end,Class<T> clazz);






}
