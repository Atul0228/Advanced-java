package service;

import java.util.Scanner;

import beans.Employee;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	static Scanner sc=new Scanner(System.in);
	static EmployeeDao eDao=new EmployeeDaoImpl();
	
	
	@Override
	public boolean addEmployee() {
		System.out.println("Enter the Employee Id");
		int id=sc.nextInt();
		
		System.out.println("Enter the Employee Name");
		String name=sc.next();
		
		System.out.println("Enter the Sal");
		double sal=sc.nextDouble();
		
		System.out.println("Enter the address of the employee");
		String add=sc.next();
		
		Employee e=new Employee(id,name,sal,add);
		
		
		return eDao.addEmployee(e);
	}


	public boolean deleteById(int id) {
		
		return eDao.deleteById(id);
	}


	@Override
	public boolean ModifyData(int id, String name, double sal, String add) {
		// TODO Auto-generated method stub
		return eDao.ModifyData(id,name,sal,add);
	}


	

}
