package com.demo.service;

import com.demo.beans.Product;
import com.demo.dao.AddProduct;
import com.demo.dao.AddProductDao;

public class AddNewProductImpl implements AddNewProductService
{
		static AddProductDao a=new AddProduct();
	@Override
	public void addProduct(Product product) 
	{
		
		a.addNewProduct(product);
		
	}
	
}
