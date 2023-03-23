package com.rk.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class PlayerInfo {
	@Id
	private Integer pid;
	private String pname;
	private String[] nickName;
	private List<String> friends;
	private Set<Long> phoneNumber;
	private Map<String, Long> idDetails;
	private Properties kitInfo;
}
