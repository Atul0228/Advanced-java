package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.productDaoImpl;

public class ProductServiceImpl implements ProductService{

	ProductDao pDao=new productDaoImpl(); 
	
	static Scanner sc=new Scanner(System.in);
	@Override
	public boolean addData() {
		int pid,qty;
		double price;
		String pname;
		
		System.out.println("Enter the Product Id");
		pid=sc.nextInt();
		
		System.out.println("Enter the Product Name");
		pname=sc.next();
		
		System.out.println("Enter the Quantity of product");
		qty=sc.nextInt();
		
		System.out.println("Enter the price of Product");
		price=sc.nextDouble();
		
		System.out.println("Enter the Date of manufacturing in (\"dd/MM/yyyy\")");
		String dt=sc.next();
		
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Product p=new Product(pid,qty,pname,price,ldt);
		
		return pDao.addData(p);
	}

	

}
