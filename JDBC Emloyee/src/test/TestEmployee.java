package test;

import java.util.Scanner;

import service.EmployeeService;
import service.EmployeeServiceImpl;

public class TestEmployee {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		EmployeeService eService=new EmployeeServiceImpl(); 
		int choice=0;
		
		do {
			System.out.println("1) Add Employee/n  2) Delete employee/n 3) Modify Employee");
			choice=sc.nextInt();
			
			switch(choice) 
			{
			
			case 1->{
				if(eService.addEmployee())
				{
					System.out.println("Employee Added");
				}else {
					System.out.println("Employee not added");
				}
			}
			
			case 2->{
				System.out.println("enter id");
				int id=sc.nextInt();
				boolean status =eService.deleteById(id);
			}
			
			case 3->{
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				
				System.out.println("enter sal");
				double sal=sc.nextDouble();
				
				System.out.println("enter add");
				String add=sc.next();
				
				
				boolean status =eService.ModifyData(id,name,sal,add);
			}
			
			default ->{
				System.out.println("Wrong Choice");
			}
			
			}
		}while(choice!=2);

	}

}
