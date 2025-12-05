package com.demo.service;

import java.util.List;

import com.demo.beans.Cart;

public interface CartService {

    Cart createCart(String owner);
    Cart getCart(Long id);
    List<Cart> getAll();
    Cart addProductToCart(Long cartId, Long productId);
    Cart removeProductFromCart(Long cartId, Long productId);
    void deleteCart(Long id);
}
