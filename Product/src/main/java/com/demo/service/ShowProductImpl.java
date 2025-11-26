package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ShowProductImpl implements ShowProductService{

	static ProductDao pDao=new ProductDaoImpl();
	@Override
	public List<Product> getAllProducts() {
		
		return pDao.getAllProducts();
	}

}
