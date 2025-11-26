package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.ValidUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;


@WebServlet(description = "use to validate valid user", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		LoginService lService=new LoginServiceImpl();
		
		ValidUser p=lService.checkValidUser(uname,pass);
		
		if(p!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/ShowProduct");
			rd.forward(req, resp);
		
			
			
		}else {
			out.println("<h1>Inalid User</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		
	}

}
