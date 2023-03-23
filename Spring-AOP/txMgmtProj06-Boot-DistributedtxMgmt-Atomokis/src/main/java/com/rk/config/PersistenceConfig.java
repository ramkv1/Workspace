package com.rk.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistenceConfig {
	
	@Bean(name = "oraAksDs")
	public AtomikosDataSourceBean createAksDsBeanForOracle() {
		AtomikosDataSourceBean ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("oraXA");
		ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		Properties props=new Properties();
		props.setProperty("databaseName", "xe");
		props.setProperty("user","root");
		props.setProperty("password", "@Vamshi57");
		props.setProperty("URL", "jdbc:oracle:thin:@localhost:1521:xe");
		ds.setXaProperties(props);
		ds.setMaxPoolSize(1000);
		ds.setMinPoolSize(10);
		ds.setMaxIdleTime(2000);
		return ds;
	}
	@Bean(name = "mysqlAksDs")
	public AtomikosDataSourceBean createAksDsBeanForMysql() {
		AtomikosDataSourceBean ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("oraXA");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		Properties props=new Properties();
		props.setProperty("databaseName", "mysqlDB");
		props.setProperty("user","root");
		props.setProperty("password", "@Vamshi57");
		props.setProperty("URL", "jdbc:mysql:///mysqlDB");
		ds.setXaProperties(props);
		ds.setMaxPoolSize(1000);
		ds.setMinPoolSize(10);
		ds.setMaxIdleTime(2000);
		return ds;
	}
	@Bean(name = "oraJT")
	private JdbcTemplate createJTForOracle() {
		return new JdbcTemplate(createAksDsBeanForOracle());
	}
	@Bean(name = "mysqlJT")
	private JdbcTemplate createJTForMysql() {
		return new JdbcTemplate(createAksDsBeanForMysql());
	}
}
