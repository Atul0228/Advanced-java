package com.demo.beans;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
	private int roll_no;
	private String name;
	private String address;
	private LocalDate DOB;
	
	public Student(int roll_no, String name, String address, LocalDate dOB) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.address = address;
		DOB = dOB;
	}
	public Student() {
		super();
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", address=" + address + ", DOB=" + DOB + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Student other = (Student) obj;
		return roll_no == other.roll_no;
	}
	
	
	
}
