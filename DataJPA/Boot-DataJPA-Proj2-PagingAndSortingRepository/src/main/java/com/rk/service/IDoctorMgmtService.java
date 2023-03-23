package com.rk.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rk.entity.Doctor;

public interface IDoctorMgmtService {
	public Iterable<Doctor> showDoctorBySorting(boolean asc,String ... props);
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo,int pageSize,boolean ascOrder,String props);
	public void showDataThroughPagination(int pageSize);
	public String deleteDoctorsByIdsInBatch(List<Integer> ids);
}
