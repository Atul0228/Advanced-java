package com.demo.service;

import com.demo.beans.Cart;
import com.demo.beans.Product;
import com.demo.dao.CartDaoImpl;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDaoImpl cartDao = new CartDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public Cart createCart(Cart c) { return cartDao.save(c); }

    @Override
    public Cart getCart(Long id) { return cartDao.findById(id); }

    @Override
    public List<Cart> getAllCarts() { return cartDao.findAll(); }

    @Override
    public void updateCart(Cart c) { cartDao.update(c); }

    @Override
    public void deleteCart(Long id) { cartDao.delete(id); }

    @Override
    public Cart addProductToCart(Long cartId, Long productId) {
        Cart cart = cartDao.findById(cartId);
        Product prod = productDao.findById(productId);
        if (cart == null || prod == null) return null;
        cart.addProduct(prod);
        cartDao.update(cart);
        return cart;
    }

    @Override
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartDao.findById(cartId);
        Product prod = productDao.findById(productId);
        if (cart == null || prod == null) return null;
        cart.removeProduct(prod);
        cartDao.update(cart);
        return cart;
    }
}
