package com.rk.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer {
	private Integer cid;
	private String cname;
	private String cadd;
	private List<Company> companiesList;
	@JsonFormat(pattern = "yyyy-MM-DD")
	private LocalDate dob;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime purchaseDateTime;
	private List<Map<String,Object>> productDetails;
	//Getters and Setters
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
	public List<Company> getCompaniesList() {
		return companiesList;
	}
	public void setCompaniesList(List<Company> companiesList) {
		this.companiesList = companiesList;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}
	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}
	public List<Map<String, Object>> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<Map<String, Object>> productDetails) {
		this.productDetails = productDetails;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cadd=" + cadd + ", companiesList=" + companiesList
				+ ", dob=" + dob + ", purchaseDateTime=" + purchaseDateTime + ", productDetails=" + productDetails
				+ "]";
	}
	
	
	
}
