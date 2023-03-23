package com.rk.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "LOB_MARRIAGE_SEEKER")
public class MarriageSeeker implements Serializable {
	@Id
	@GeneratedValue
	private Integer msid;
	@NonNull
	@Column(length = 20)
	private String msname;
	@NonNull
	@Column(length = 20)
	private String msaddrs;
	@NonNull
	private Boolean indian;
	@NonNull
	private LocalDateTime dob;
	@NonNull
	@Lob
	private byte[] msphoto;
	@NonNull
	@Lob
	private char[] msbiodata;
	
	
	
}
