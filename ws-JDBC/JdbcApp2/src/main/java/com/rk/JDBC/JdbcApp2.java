//Insert No.of Records on database using JDBC
package com.rk.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcApp2{
	public static void main(String[] args) throws Exception {
		//load a register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection between java application and database
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlDB","root","@Vamshi57");
		
		
		//prepair statement
		Statement st=con.createStatement();
		
		//create BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Employee Number:::");
			int emp_id=Integer.parseInt(br.readLine());
			System.out.println("Employee Name");
			String emp_name=br.readLine();
			System.out.println("Employee Department");
			String dept_name=br.readLine();
			System.out.println("Employee Salary");
			int salary=Integer.parseInt(br.readLine());
			
			st.executeUpdate("insert into employee values("+emp_id+","+emp_name+","+dept_name+","+salary+")");
			System.out.println("Employee Inserted successfully");
			System.out.println("Do you want to insert another employee[Yes/No]? :");
			String option=br.readLine();
			if(option.equals("No")) {
				break;
			}
		}
		//close the connection
		
		con.close();
	}
}
