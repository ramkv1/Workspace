package com.rk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.rk.dao")
public class PersistanceConfig {
	
	@Bean(name = "hkDs")
	public HikariDataSource createHKDataSource() {
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkDs.setJdbcUrl("jdbc:mysql:///mysqlDB");
		hkDs.setUsername("root");
		hkDs.setPassword("@Vamshi57");
		return hkDs;
	}
	@Bean(name = "jt")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createHKDataSource());
	}
}
