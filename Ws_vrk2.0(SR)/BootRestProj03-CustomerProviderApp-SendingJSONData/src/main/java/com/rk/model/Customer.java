package com.rk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String cadd;
	private Double billAmt;
	
	public Customer() {
		System.out.println("Customer::0-paramConstructor)");
	}
	public Customer(Integer cno, String cname, String cadd, Double billAmt) {
		System.out.println("Customer::4-param constructor");
		this.cno = cno;
		this.cname = cname;
		this.cadd = cadd;
		this.billAmt = billAmt;
	}
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
	public Double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	
	
}
