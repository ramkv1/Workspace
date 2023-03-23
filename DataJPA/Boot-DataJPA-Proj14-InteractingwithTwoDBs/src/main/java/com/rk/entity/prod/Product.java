package com.rk.entity.prod;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "JPA_PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	@NonNull
	private String pname;
	@NonNull
	private String category;
	@NonNull
	private Double qty;
	@NonNull
	private Double price;
}
