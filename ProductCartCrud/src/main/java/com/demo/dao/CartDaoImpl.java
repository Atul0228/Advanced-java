package com.demo.dao;

import com.demo.beans.Cart;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CartDaoImpl implements CartDao {

    private Session open() {
        return HibernateUtil.getSf().openSession();
    }

    @Override
    public Cart save(Cart c) {
        Transaction tx = null;
        try (Session s = open()) {
            tx = s.beginTransaction();
            s.save(c);
            tx.commit();
            return c;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    @Override
    public Cart find(Long id) {
        try (Session s = open()) {
            return s.get(Cart.class, id);
        }
    }

    @Override
    public List<Cart> findAll() {
        try (Session s = open()) {
            return s.createQuery("from Cart", Cart.class).list();
        }
    }

    @Override
    public void update(Cart c) {
        Transaction tx = null;
        try (Session s = open()) {
            tx = s.beginTransaction();
            s.update(c);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    @Override
    public void delete(Long id) {
        Transaction tx = null;
        try (Session s = open()) {
            tx = s.beginTransaction();
            Cart c = s.get(Cart.class, id);
            if (c != null) s.delete(c);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }
}
