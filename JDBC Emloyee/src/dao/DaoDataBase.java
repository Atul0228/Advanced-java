package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoDataBase {
	
static Connection con=null;


	public static Connection getConnection() 
	{
		if(con==null)
		{
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://192.168.10.117/dac12?useSSL=false";
				con=DriverManager.getConnection(url,"dac12","welcome");
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return con;
		}
		return null;
	}

}
