package com.demo.dao;

import com.demo.beans.Product;
import java.util.List;

public interface ProductDao {

    Product save(Product p);
    Product find(Long id);
    List<Product> findAll();
    void update(Product p);
    void delete(Long id);
}
