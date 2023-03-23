package com.rk.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddSevlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		
		int k= i+j;
		/*
		 * PrintWriter out=res.getWriter();
		 * 
		 * 
		 * out.println("The Result is====>"+k); //Session management
		 * 
		 * req.setAttribute("k",k); //Request redirect RequestDispatcher
		 * rd=req.getRequestDispatcher("/sq"); rd.forward(req, res);
		 */
		 
//		res.sendRedirect("sq?k="+k);   ///===>Url rewriting
		
		
		  ///======HttpSession============ 
		HttpSession session=req.getSession();
		session.setAttribute("k",k);
		
		res.sendRedirect("sq");
		 

		/*
		 * //====Cookies======== Cookie cookie=new Cookie("k",k+" ");
		 * res.addCookie(cookie); res.sendRedirect("sq");
		 */
		 
	}
}
