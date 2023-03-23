package com.rk.sbeans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix ="emp.info")
public class Employee {
	private Integer empNo;
	private String empName;
	private String empAddrs;
	// Array Type
	private String[] FavColors;
	//Collection List
	private List<String> nickNames;
	//Collection set
	private Set<Long> PhoneNumbers;
	//Collection Map
	private Map<String,Long> idDetails;
	//HAS_A property
	private Company company;
	//Getters and Setters
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddrs() {
		return empAddrs;
	}
	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}
	public String[] getFavColors() {
		return FavColors;
	}
	public void setFavColors(String[] favColors) {
		FavColors = favColors;
	}
	public List<String> getNickNames() {
		return nickNames;
	}
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	public Set<Long> getPhoneNumbers() {
		return PhoneNumbers;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}
	public Map<String, Long> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, Long> idDetails) {
		this.idDetails = idDetails;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	//toString 
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empAddrs=" + empAddrs + ", FavColors="
				+ Arrays.toString(FavColors) + ", nickNames=" + nickNames + ", PhoneNumbers=" + PhoneNumbers
				+ ", idDetails=" + idDetails + ", company=" + company + "]";
	}
	
}