package com.demo.service;

import java.util.List;
import com.demo.beans.Product;

public interface ProductService {
    Product addProduct(String name, String desc, double price);
    Product getProduct(Long id);
    List<Product> getAll();
    void updateProduct(Product p);
    void deleteProduct(Long id);
}
