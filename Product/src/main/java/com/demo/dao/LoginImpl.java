package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.ValidUser;

public class LoginImpl implements Login{

	static Connection con=DBUtil.getUserConnection();
	
	static PreparedStatement selectAllUser;
	
	@Override
	public ValidUser checkUser(String uname, String pass) {
		
		try {
			
			selectAllUser=con.prepareStatement("select * from productLogin where uname=? and pass=?");
			
			selectAllUser.setString(1, uname);
			selectAllUser.setString(2, pass);
			
			ResultSet rs = selectAllUser.executeQuery();
			
			if(rs.next())
			{
				ValidUser p=new ValidUser(rs.getString(1),rs.getString(2));
				return p;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
