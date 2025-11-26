package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

static Connection con;
	
	public static Connection getUserConnection()
	{
//		Class.forName("");
		if(con==null) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac13?useSSL=false";

			
			con=DriverManager.getConnection(url, "dac13", "welcome");
			
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return con;
	}
}
