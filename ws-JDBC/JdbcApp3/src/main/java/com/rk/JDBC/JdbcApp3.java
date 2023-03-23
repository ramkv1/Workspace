//Updations on Database table through jdbc Application
package com.rk.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcApp3{
	public static void main(String[] args) throws Exception {
		//load a register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection between java application and database
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlDB","root","@Vamshi57");
		
		
		//prepair statement
		Statement st=con.createStatement();
		
		//create BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bonus Amount::");
		int bonus_Amt=Integer.parseInt(br.readLine());
		System.out.println("Salary Range");
		int sal_range=Integer.parseInt(br.readLine());
		int rowCount=st.executeUpdate("update employee set salary=salary+"+bonus_Amt+" Where salary<"+sal_range);
		System.out.println("Employee Updated :"+rowCount);
		//close the connection
		con.close();
	}
}
