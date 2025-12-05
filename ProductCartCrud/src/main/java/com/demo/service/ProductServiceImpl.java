package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

    private ProductDao dao = new ProductDaoImpl();

    @Override
    public Product addProduct(String name, String desc, double price) {
        Product p = new Product(null, name, desc, price);
        return dao.save(p);
    }

    @Override
    public Product getProduct(Long id) {
        return dao.find(id);
    }

    @Override
    public List<Product> getAll() {
        return dao.findAll();
    }

    @Override
    public void updateProduct(Product p) {
        dao.update(p);
    }

    @Override
    public void deleteProduct(Long id) {
        dao.delete(id);
    }
}
