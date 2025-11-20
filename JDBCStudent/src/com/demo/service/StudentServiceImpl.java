package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.dao.StudentDAo;
import com.demo.dao.StudentDAoImpl;

public class StudentServiceImpl implements StudentService{

	static Scanner sc=new Scanner(System.in);
	
	static StudentDAo sDao=new StudentDAoImpl();
	
	@Override
	public boolean addStudent() 
	{
		
		System.out.println("Enter the Roll No Of Student");
		int id=sc.nextInt();

		System.out.println("Enter the name of Student");
		String name=sc.next();
		
		System.out.println("Enter the Address Of the Student");
		String add=sc.next();
		
		System.out.println("Enter the Date of Birth of Student(dd/mm/yyyy)");
		String dob=sc.next();
		
		
		
		return sDao.addStudent(id,name,add,dob);
	}

	@Override
	public boolean updateStudent() {
	    System.out.println("Enter the Roll no to Update");
	    int rollno = sc.nextInt();
	    
	    System.out.println("Enter the New Roll no");
	    int newRoll = sc.nextInt();
	   sc.nextLine();
	    System.out.println("Enter the Name of Student");
	    String name = sc.nextLine();
	  
	    System.out.println("Enter the Address of Student");
	    
	    String add = sc.nextLine();
	    
	    System.out.println("Enter the Date of Birth (yyyy/mm/dd)");
	    String dob = sc.next();
	    
	    return sDao.updateStudent(rollno, newRoll, name, add, dob);
	}

	@Override
	public List<Student> show() {
		
		return sDao.show();
	}


	

	

}
