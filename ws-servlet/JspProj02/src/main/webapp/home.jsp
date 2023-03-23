<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<%!
	int i=10;
	
	%>
	<%
		try{
			out.println(7/0);
		}
	catch(Exception e){
		out.println("Error "+e.getMessage());
	}
		
	
	%>
	<%=i %>
</body>
</html>