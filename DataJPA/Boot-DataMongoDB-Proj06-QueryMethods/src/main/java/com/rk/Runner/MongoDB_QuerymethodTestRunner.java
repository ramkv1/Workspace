package com.rk.Runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.Document.Employee;
import com.rk.Service.IEmployeeMgmtService;


@Component
public class MongoDB_QuerymethodTestRunner implements CommandLineRunner{

	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*	List<Object[]> list=service.fetchEmpsDataByAddrs("Hyd");
			list.forEach(row->{
				for(Object val:row) {
				System.out.println(val+" ");
				}
				//System.out.println();
			});
			System.out.println("____________________________________________________");
			
			service.fetchempallDataByAddrs("Hyd").forEach(System.out::println);
		
			System.out.println("___________________________________");
			service.fetchempDataByAddrsandSalary(70000.0, "Hyd").forEach(row->
			{
				System.out.println(Arrays.toString(row));
			});
			
			*/
		System.out.println("__________________________________________________");
		service.fetchEmpDataBySalaryRange(900000.0,100000.0).forEach(System.out::println);
		
		
		System.out.println("___________________________________________________");
		service.fetchEmpsFullDataByAddresses("Hyd", "Kkr").forEach(System.out::println);
	}
	
	
}
