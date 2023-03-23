<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String url="jdbc:mysql://localhost:3306/learndb";
		String username="root";
		String password="@Vamshi57";
		
		String sql="select * from rk_table";
		
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		rs.next();
	
	%>
	
	Employee Id:<% rs.getInt(1); %> <br>
	Name: <% rs.getString(2); %> <br>
	Marks: <% rs.getString(3); %> 

</body>
</html>