//Implementing connection pooling (Standalone application)
package com.rk.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class JdbcApp39{
	public static void main(String[] args) throws Exception,SQLException {
		MysqlConnectionPoolDataSource ds=new MysqlConnectionPoolDataSource();
		ds.setURL("jdbc:mysql:///mysqlDB");
		ds.setUser("root");
		ds.setPassword("@Vamshi57");
		PooledConnection pc=ds.getPooledConnection();
		Connection con=pc.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee");
		System.out.println("emp_id emp_name salary");
		System.out.println("-------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+rs.getInt(4));
		}
	}
}
