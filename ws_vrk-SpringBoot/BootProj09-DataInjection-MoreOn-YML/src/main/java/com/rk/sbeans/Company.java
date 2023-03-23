package com.rk.sbeans;

public class Company {
	//Simple properties
	private String name;
	private Integer size;
	private String addrs;
	private Long pincode;
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	//ToString
	@Override
	public String toString() {
		return "Company [name=" + name + ", size=" + size + ", addrs=" + addrs + ", pincode=" + pincode + "]";
	}
	
}
