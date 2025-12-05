package com.demo.service;

import com.demo.beans.Cart;
import java.util.List;

public interface CartService {
    Cart createCart(Cart c);
    Cart getCart(Long id);
    List<Cart> getAllCarts();
    void updateCart(Cart c);
    void deleteCart(Long id);
    Cart addProductToCart(Long cartId, Long productId);
    Cart removeProductFromCart(Long cartId, Long productId);
}
