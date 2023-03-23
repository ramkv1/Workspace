package com.rk.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String cadd;
	private Double billamt;
	//1-D array
	private String[] favColors;
	//1-D array
	private List<String> nickNames;
	//1-D array
	private Set<Long> phoneNumber;
	//2-D array
	private Map<String,Long> idDetails;
	// HAS-A property(2-D array)
	private Company company;
	private LocalDateTime drop;
	private Boolean married;
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public Double getBillamt() {
		return billamt;
	}
	public void setBillamt(Double billamt) {
		this.billamt = billamt;
	}
	public String[] getFavColors() {
		return favColors;
	}
	public void setFavColors(String[] favColors) {
		this.favColors = favColors;
	}
	public List<String> getNickNames() {
		return nickNames;
	}
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	public Set<Long> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Set<Long> phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public LocalDateTime getDrop() {
		return drop;
	}
	public void setDrop(LocalDateTime drop) {
		this.drop = drop;
	}
	public Boolean getMarried() {
		return married;
	}
	public void setMarried(Boolean married) {
		this.married = married;
	}
	public Customer() {
		System.out.println("Company::0-paramconstructor");
	}
	public Customer(Integer cno, String cname, String cadd, Double billamt, String[] favColors, List<String> nickNames,
			Set<Long> phoneNumber, Map<String, Long> idDetails, Company company, LocalDateTime drop, Boolean married) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cadd = cadd;
		this.billamt = billamt;
		this.favColors = favColors;
		this.nickNames = nickNames;
		this.phoneNumber = phoneNumber;
		this.idDetails = idDetails;
		this.company = company;
		this.drop = drop;
		this.married = married;
	}
	
}
