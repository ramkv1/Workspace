package com.rk.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 servletConfig  $ ServletContext
*/
public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		PrintWriter out=response.getWriter();
		out.println("Hii ");
		
		ServletConfig cg=getServletConfig();
		String str=cg.getInitParameter("name");
		out.println(str);
	}
}
