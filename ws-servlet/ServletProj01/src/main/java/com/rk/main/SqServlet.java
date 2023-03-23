package com.rk.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		
		
		/*
		 * int k=Integer.parseInt(req.getParameter("k")); k=k*k; PrintWriter
		 * out=res.getWriter(); out.println("Result is k===>"+k);
		 */
		/*
		 * System.out.println("sq called"); PrintWriter out=res.getWriter();
		 * out.println("sq Servlet");
		 */
		//=============Session===================
		
		HttpSession session=req.getSession();
		
		int k=(int) session.getAttribute("k");
		
//		session.removeAttribute("k");      =======>To remove the session
		/*
//		 * int k=0;
		 * 
		 * Cookie cookie[]=req.getCookies(); for(Cookie c:cookie) {
		 * if(c.getName().equals("k")) k=Integer.parseInt(c.getValue()); }
		 */
		 k=k*k;
		 PrintWriter out=res.getWriter();
		
		 out.println("Result is k===>"+k);

	}
}
