package com.rk.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.rk.entity.prod.Product;
import com.rk.entity.promos.Offers;
import com.rk.repository.prod.IProductRepository;
import com.rk.repository.promos.IOffersRepository;

public class MultiDBInterationTestRunner implements CommandLineRunner {

	@Autowired
	private IProductRepository prodRepo;
	@Autowired
	private IOffersRepository OffersRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		// save product
		System.out.println("Saving multiple products::"+prodRepo.saveAll(List.of(new Product("Table","Furniture",10.0,3000.0),
																				new Product("chair","Furniture",12.0,4000.0),
																				new Product("Sofa","Furniture",15.0,4000.0)
																				)));
		
		System.out.println("______________________________________");
		
		
		System.out.println("Saving Multiple Offers::"+OffersRepo.saveAll(List.of(new Offers("Summer Offers",25.0,LocalDate.of(2022, 10, 24)),
																				new Offers("Winter Offers",30.0,LocalDate.of(2025, 11, 18))
																				)));

	}

}
