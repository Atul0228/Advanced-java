package com.demo.service;

import com.demo.beans.Product;
import com.demo.beans.ValidUser;

public interface LoginService {

	ValidUser checkValidUser(String uname, String pass);

}
