package com.demo.test;
import com.demo.service.*;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		ProductService p=new ProductServiceImpl();
		
		int choice=0;
		do {
			System.out.println("1) Add new product");
			System.out.println("2)Display product");
			System.out.println("3)delete product");
			System.out.println("4 modify product");
			System.out.println("5)find by id");
			System.out.println("6)display in sorted order");
			System.out.println("7)exit");
			 choice =sc.nextInt();
			
			 switch(choice) {
			 case 1 ->{
				 
				 	System.out.println("We are adding new Product");
				 	if(p.addData())
				 	{
				 		System.out.println("Product Entered Sucessfully");
				 	}else {
				 		System.out.println("Product was not entered ");
				 	}
			 }
			 
			 case 2 ->{
			 		
			 }
			 
			 case 3 ->{
			 		
			 }
			 
			 case 4 ->{
			 		
			 }
			 
			 case 5 ->{
			 		
			 }
			 
			 case 6 ->{
			 		
			 }
			 
			 case 7 ->{
			 		sc.close();
			 		return;
			 }
			 }
			
			
			
			
		}while(choice!=7);

	}

}
