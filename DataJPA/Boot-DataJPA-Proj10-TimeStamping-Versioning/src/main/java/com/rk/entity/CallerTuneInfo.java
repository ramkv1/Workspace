package com.rk.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CALLER_TUNE_INFO")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CallerTuneInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tuneId;
	@NonNull
	@Column(length = 20)
	private String tuneName;
	@Column(length = 20)
	@NonNull
	private String movieName;
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer updatedCount=0;
	
	@Column(name = "SERVICE_OPTED_ON")
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	
	@Column(name = "LASTLY_UPDATED_ON")
	@UpdateTimestamp
	private LocalDateTime lastlyUpdatedOn;
}
