package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.beans.Product;

public class AddProduct implements AddProductDao
{
	static Connection con=DBUtil.getUserConnection();

	static PreparedStatement addProduct;
	
	
	
	@Override
	public void addNewProduct(Product product)
	{
	try {
		addProduct=con.prepareStatement("insert into product1 values(?,?,?,?)");
		addProduct.setInt(1, product.getPid());
		addProduct.setString(2, product.getPname());
		addProduct.setInt(3, product.getQty());
		addProduct.setDouble(4, product.getPrice());
		addProduct.executeUpdate();
//		return n>0;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
//	return false;
	}
	
}
