package com.rk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EMPLOYEE_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;
	private Double gross_salary;
	private Double net_salary;
	
}
