package com.rk.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SelectTest
{
	private static Logger logger=Logger.getLogger(SelectTest.class);
	static {
		try {
			//create Layout obj
			SimpleLayout layout=new SimpleLayout();
			//create Appender objext having layout obj
			ConsoleAppender appender=new ConsoleAppender(layout);
			//add appendent obj to logger obj
			logger.addAppender(appender);
			//logger level to retive log messages
			//logger.setLevel(Level.DEBUG);
			//logger.setLevel(Level.OFF);
			logger.setLevel(Level.ALL);
			logger.info("com.rk.jdbc.SelectTest::Log4j setup ready");
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.fatal("com.rk.jdbc.SelectTest:: Problem while setting up Log4j");
		}
	}
	
	public static void main(String args[]) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//Load JDBC Driver class
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("com.rk.jdbc.SelectTest:: JDBC driver driver class loader");
			//establish the connnection (Road)
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root", "@Vamshi57");
			
			logger.info("com.rk.jdbc.SelectTest:: Connection is established between DB s/w");
			// Create JDBC Statement Object (Vehicle)
			if(con!=null) {
				st = con.createStatement();
				logger.debug("com.rk.jdbc.SelectTest:: JDBC Statement Object is created");
			}
			//send and execute SQL SELECT quary in Db s/w and get JDBC Resultset Object
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
			logger.fatal("com.rk.jdbc.SelectTest:: unknow problem"+e.getMessage());
		}
			finally {
				//close jdbc objs
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
