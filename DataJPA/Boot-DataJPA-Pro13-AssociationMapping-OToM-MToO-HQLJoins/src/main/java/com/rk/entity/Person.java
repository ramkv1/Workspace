package com.rk.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "JPA_OTM_PERSON")
@Setter
@Getter
@RequiredArgsConstructor
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	@NonNull
	private String pname;
	@Column(length = 20)
	@NonNull
	private String paddrs;
	
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,mappedBy = "personInfo")
	//@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	/*@NonNull*/
	private Set<PhoneNumber> contactDetails; //build one to Many association from parent

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}

	public Person() {
		System.out.println("Person::0-param constructor");
	}

}
