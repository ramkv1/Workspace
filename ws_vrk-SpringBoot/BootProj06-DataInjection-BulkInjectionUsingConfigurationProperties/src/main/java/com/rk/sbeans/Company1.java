package com.rk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("comp1")
public class Company1 {
	@Value("${org.info.name}")
	private String cname;
	@Value("${org.info.location}")
	private String cLocation;
	@Value("${org.info.size1}")
	private Integer csize;
	@Value("${org.info.type}")
	private String type;
	@Value("${org.info.contact}")
	private Integer cContactNumber;
	@Override
	public String toString() {
		return "Company1 [cname=" + cname + ", cLocation=" + cLocation + ", csize=" + csize + ", type=" + type
				+ ", cContactNumber=" + cContactNumber + "]";
	} 
	
	
}
