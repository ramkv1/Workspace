package com.rk.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp1{
	public static void main(String[] args) throws Exception {
		//load a register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection between java application and database
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlDB","root","@Vamshi57");
		
		
		//prepair statement
		Statement st=con.createStatement();
		
		//create BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//Take table name as the dynamic input
		
		System.out.println("Enter Table name");
		
		String tname=br.readLine();
		
		//prepair SQLQuery
		
		String sql="create table::"+tname+"(eno int,ename varchar2(10),esal number)";
		
		//Execute SQl query
		
		st.execute(sql);
		
		System.out.println("table created successfully");
		//close the connection
		
		con.close();
	}
}
