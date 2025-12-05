package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Cart;
import com.demo.beans.Product;
import com.demo.dao.CartDao;
import com.demo.dao.CartDaoImpl;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class CartServiceImpl implements CartService {

    private CartDao cartDao = new CartDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public Cart createCart(String owner) {
        Cart c = new Cart(null, owner, null);
        return cartDao.save(c);
    }

    @Override
    public Cart getCart(Long id) {
        return cartDao.find(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartDao.findAll();
    }

    @Override
    public Cart addProductToCart(Long cartId, Long productId) {
        Cart c = cartDao.find(cartId);
        Product p = productDao.find(productId);

        if (c == null || p == null) return null;

        if (c.getProducts() == null)
            c.setProducts(new ArrayList<>());

        boolean exists = c.getProducts()
                .stream()
                .anyMatch(pr -> pr.getId().equals(productId));

        if (!exists) {
            c.getProducts().add(p);
            cartDao.update(c);
        }
        return c;
    }

    @Override
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Cart c = cartDao.find(cartId);
        if (c == null || c.getProducts() == null) return null;

        c.getProducts().removeIf(pr -> pr.getId().equals(productId));

        cartDao.update(c);
        return c;
    }

    @Override
    public void deleteCart(Long id) {
        cartDao.delete(id);
    }
}
