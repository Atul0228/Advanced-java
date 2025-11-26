package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ShowProductImpl;
import com.demo.service.ShowProductService;


@WebServlet(description = "Showing All The Product Present In The Data Base", urlPatterns = { "/ShowProduct" })
public class ShowProduct extends HttpServlet {
	
	static ShowProductService showService=new ShowProductImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		List<Product> p =showService.getAllProducts();
		out.println("<html><body>");
		
		for(Product p1: p)
		{
			out.println("<p>");
			out.println("Product Id is:-"+p1.getPid()+"</br>");
			out.println("Product Name is:-"+p1.getPname()+"</br>");
			out.println("Product Quentity is:-"+p1.getQty()+"</br>");
			out.println("Product Price is:-"+p1.getPrice()+"</br>");
			out.println("</p>");
		}
		
		out.println("</body></html>");
	}

}
