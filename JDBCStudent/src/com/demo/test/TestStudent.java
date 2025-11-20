package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

public class TestStudent {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);

	StudentService sService = new StudentServiceImpl();
	
	int choice=0;
	
	do {
		System.out.println("1) Enter New Student");
		System.out.println("2) Show All Student");
		System.out.println("3) Update Student By RollNo ");
		System.out.println("4) Delete student By Id");
		
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1->{
			System.out.println("Enter the student details");
			if(sService.addStudent())
			{
				System.out.println("Student Added");
				
			}else {
				System.out.println("Student Not Added");
			}
		}
		
		case 2->{
			List<Student> sList=sService.show();
			sList.forEach(System.out::println);
			
		}
		
		case 3->{
			
//			System.out.println("Enter the Roll No for update Values");
//			int id=sc.nextInt();
			
			if(sService.updateStudent())
			{
				
			}else {
				
			}
		}
		
		
		default-> {
			System.out.println("Wrong Choice");
		}
		
		}
	
	}while(choice<=5);

}
}
