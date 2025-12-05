package com.demo.dao;

import com.demo.beans.Cart;
import java.util.List;

public interface CartDao {
    Cart save(Cart c);
    Cart findById(Long id);
    List<Cart> findAll();
    void update(Cart c);
    void delete(Long id);
}
