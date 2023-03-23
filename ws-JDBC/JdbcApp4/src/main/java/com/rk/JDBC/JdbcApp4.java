//Delete on Database table through jdbc Application
package com.rk.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcApp4{
	public static void main(String[] args) throws Exception {
		//load a register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection between java application and database
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlDB","root","@Vamshi57");
		
		
		//prepair statement
		Statement st=con.createStatement();
		
		//create BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Salary Range::");
		int sal_Range=Integer.parseInt(br.readLine());
		int rowCount=st.executeUpdate("delete from employee where salary<"+sal_Range);
		System.out.println("Records Deleted ::"+rowCount);
		//close the connection
		con.close();
	}
}
