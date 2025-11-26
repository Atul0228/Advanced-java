package com.demo.service;

import com.demo.beans.ValidUser;
import com.demo.dao.Login;
import com.demo.dao.LoginImpl;

public class LoginServiceImpl implements LoginService{

	static Login l=new LoginImpl();
	
	@Override
	public ValidUser checkValidUser(String uname, String pass) 
	{
		
		return l.checkUser(uname,pass);
	}

}
