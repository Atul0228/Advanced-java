package com.demo.beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
	
	private int pid;
	private int qty;
	private String pname;
	private double price;
	private LocalDate ldt;
	
	
	public Product() {
		super();
	}
	
	
	public Product(int pid, int qty, String pname, double price, LocalDate ldt) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.pname = pname;
		this.price = price;
		this.ldt = ldt;
	}
	
	
	public int getPid() {
		return pid;
	}
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	public int getQty() {
		return qty;
	}
	
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public LocalDate getLdt() {
		return ldt;
	}
	public void setLdt(LocalDate ldt) {
		this.ldt = ldt;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", pname=" + pname + ", price=" + price + ", ldt=" + ldt + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		Product other = (Product) obj;
		return pid == other.pid;
	}
	
	

	

}
