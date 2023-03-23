package com.rk.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.entity.MarriageSeeker;
import com.rk.service.IMarriagerSeekerMgmtService;

//@Component
public class LOBsTestRunner implements CommandLineRunner {
	
	@Autowired
	private IMarriagerSeekerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Marriage seeker name::");
		String name=sc.next();
		
		System.out.println("Marriage seeker Address::");
		String addrs=sc.next();
		
		System.out.println("Marriage seeker Indian?::");
		Boolean indian=sc.nextBoolean();
		
		System.out.println("Marriage seeker DOB(YYYY-MM-DDThh:mm:ss)::");
		String sdob=sc.next();
		
		System.out.println("Marriage seeker Photo file path::");
		sc.nextLine();
		String photoPath=sc.nextLine();
		
		System.out.println("Marriage seeker resume file path::");
		String resumePath=sc.nextLine();
		
		//Convert String data values to java.time.LocalDateTime class Object
		LocalDateTime dob=LocalDateTime.parse(sdob);
		
		//Create byte[] form photo file
		InputStream is=new FileInputStream(photoPath);
		byte[] photoContent=new byte[is.available()];
		photoContent=is.readAllBytes();
		
		
		//Create byte[] from photo file
		File file=new File(resumePath);
		Reader reader=new FileReader(file);
		char[] resumeContent=new char[(int) file.length()];
		
		
		//Create MarriageSeeker Object
		MarriageSeeker seeker=new MarriageSeeker(name, addrs, indian, dob, photoContent, resumeContent);
		
		try {
			String msg=service.saveMarriageSeeker(seeker);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
