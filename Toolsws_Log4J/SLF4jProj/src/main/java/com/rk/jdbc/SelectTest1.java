package com.rk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.LoggerFactory;

public class SelectTest1
{
	private static org.slf4j.Logger logger=LoggerFactory.getLogger(SelectTest1.class);
	
	
	public static void main(String args[]) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//Load JDBC Driver class
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("com.rk.jdbc.SelectTest:: JDBC driver driver class loader");
			//establish the connection (Road)
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root", "@Vamshi57");
			
			logger.info("com.rk.jdbc.SelectTest:: Connection is established between DB s/w");
			// Create JDBC Statement Object (Vehicle)
			if(con!=null) {
				st = con.createStatement();
				logger.debug("com.rk.jdbc.SelectTest:: JDBC Statement Object is created");
			}
			//send and execute SQL SELECT query in Db s/w and get JDBC Result set Object
			if(st!=null) {
			rs = st.executeQuery("select * from Employee");
			logger.debug("com.rk.jdbc.SelectTest:: SQL query is send to DB s/w for execution and ResultSet obj is generated");
			}
			if(rs!=null) {
				//process the resultSet object
			while (rs.next()!=false) 
			{//while(rs.next==true)
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				logger.warn("com.rk.jdbc.SelectTest:: The ResultSet obj are retrived using getString(-)for all cols ..change them accordingly");
			}
			logger.debug("com.rk.jdbc.SelectTest:: Resultset obj is processed");
		}
		}
		catch (SQLException se) {
			se.printStackTrace();
			logger.error("com.rk.jdbc.SelectTest:: Known DB Problem ::"+"SQL error Code"+se.getErrorCode());
			
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("com.rk.jdbc.SelectTest:: unknow problem"+e.getMessage());
		}
			finally {
				//close jdbc object
				try {
				if(rs!=null)
				{
					rs.close();
				}
				}
				catch (SQLException se) {
					se.printStackTrace(); 
				}
				//
				try {
					if(st!=null)
					{
						st.close();
					}
					} 
					catch (SQLException se) {
						se.printStackTrace(); 
					}
				try {
					if(con!=null)
					{
						con.close();
					}
					}
					catch (SQLException se) {
						se.printStackTrace(); 
					}
			}
		}
}
