package com.rk.model;

public class Company {
	private String name;
	private String addrs;
	private Integer size;
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", addrs=" + addrs + ", size=" + size + "]";
	}
	
	
	
}
