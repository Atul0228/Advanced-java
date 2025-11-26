package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{

	static Connection con;
	static PreparedStatement showAllProduct;
	static {
		con=DBUtil.getUserConnection();
		try {
			showAllProduct=con.prepareStatement("select * from product1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> getAllProducts() {
		
	List<Product> p = new ArrayList<>();
		try {
			
			ResultSet rs=showAllProduct.executeQuery();
			
			while(rs.next()) 
			{
				p.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
			}
			
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
