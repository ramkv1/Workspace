package com.rk.entity.promos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@Table(name = "JPA_OFFERS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Offers {
	@Id
	@GeneratedValue
	private Integer ofid;
	@NonNull
	@Column(length = 20)
	private String offername;
	@NonNull
	@Column(length = 20)
	private double DiscountPer;
	@NonNull
	private LocalDate validto;
	
}
