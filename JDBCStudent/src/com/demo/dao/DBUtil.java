package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	static Connection con=null;
	
	public static  Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://192.168.10.117/dac13?useSSL=false";
			
			con=DriverManager.getConnection(url,"dac13","welcome");
			
		} catch (Exception e) {


			e.printStackTrace();
		}
		return con;
	}

}
