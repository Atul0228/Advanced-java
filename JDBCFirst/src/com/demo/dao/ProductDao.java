package com.demo.dao;

import java.sql.Connection;
import java.time.LocalDate;


import com.demo.beans.Product;

public interface ProductDao {


	boolean addData(Product p);

	
}
