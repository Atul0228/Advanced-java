package com.demo.service;

import com.demo.beans.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product p);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    void updateProduct(Product p);
    void deleteProduct(Long id);
}
