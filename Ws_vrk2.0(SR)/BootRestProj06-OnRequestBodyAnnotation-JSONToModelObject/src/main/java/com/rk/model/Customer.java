package com.rk.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private Double billAmt;
	private String[] favColors;
	private List<String> nickName;
	private Map<String,Long> idDetails;
	private Set<Long> contactNumbers;
	private Address addrs;
	//Getters and setters
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
	public Double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	public String[] getFavColors() {
		return favColors;
	}
	public void setFavColors(String[] favColors) {
		this.favColors = favColors;
	}
	public List<String> getNickName() {
		return nickName;
	}
	public void setNickName(List<String> nickName) {
		this.nickName = nickName;
	}
	public Map<String, Long> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, Long> idDetails) {
		this.idDetails = idDetails;
	}
	public Set<Long> getContactNumbers() {
		return contactNumbers;
	}
	public void setContactNumbers(Set<Long> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}
	public Address getAddrs() {
		return addrs;
	}
	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}
	
}
