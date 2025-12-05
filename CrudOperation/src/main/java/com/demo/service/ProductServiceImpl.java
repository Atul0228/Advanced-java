package com.demo.service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao dao = new ProductDaoImpl();

    @Override
    public Product createProduct(Product p) { return dao.save(p); }

    @Override
    public Product getProduct(Long id) { return dao.findById(id); }

    @Override
    public List<Product> getAllProducts() { return dao.findAll(); }

    @Override
    public void updateProduct(Product p) { dao.update(p); }

    @Override
    public void deleteProduct(Long id) { dao.delete(id); }
}
