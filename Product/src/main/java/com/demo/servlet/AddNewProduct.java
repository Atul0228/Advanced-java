package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.AddNewProductImpl;
import com.demo.service.AddNewProductService;

@WebServlet(description = "Adding a new Product to the Database", urlPatterns = { "/AddNewProduct" })
public class AddNewProduct extends HttpServlet {
    
    static AddNewProductService a = new AddNewProductImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Add New Product</h2>");
        out.println("<form method='post' action='AddNewProduct'>");
        out.println("<label>Product Id</label><input type='number' name='pid'/><br/><br/>");
        out.println("<label>Product Name</label><input type='text' name='pname'/><br/><br/>");
        out.println("<label>Product Quantity</label><input type='number' name='qty'/><br/><br/>");
        out.println("<label>Product Price</label><input type='number' step='0.01' name='price'/><br/><br/>");
        out.println("<button type='submit'>Add</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int pid = Integer.parseInt(req.getParameter("pid"));
        String pname = req.getParameter("pname");
        int qty = Integer.parseInt(req.getParameter("qty"));
        double price = Double.parseDouble(req.getParameter("price"));

      
        a.addProduct(new Product(pid,pname,qty,price));

       
    }
}
