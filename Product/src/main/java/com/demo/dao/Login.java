package com.demo.dao;

import com.demo.beans.Product;
import com.demo.beans.ValidUser;

public interface Login {

	ValidUser checkUser(String uname, String pass);

}
