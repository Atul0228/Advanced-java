package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtill 
{
	static Connection con=null;
	
	

	public static Connection getConnection() {
		
		try {
			if(con == null)
			{
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://192.168.10.117/dac13?useSSL=false";
				
				con=DriverManager.getConnection(url,"dac13","welcome");
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return con;
	}

	
	
}
