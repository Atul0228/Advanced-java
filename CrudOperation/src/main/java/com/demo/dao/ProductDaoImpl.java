package com.demo.dao;

import com.demo.beans.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private Session getSession() {
        return HibernateUtil.getSf().openSession();
    }

    @Override
    public Product save(Product p) {
        Transaction tx = null;
        try (Session s = getSession()) {
            tx = s.beginTransaction();
            s.save(p);
            tx.commit();
            return p;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    @Override
    public Product findById(Long id) {
        try (Session s = getSession()) {
            return s.get(Product.class, id);
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session s = getSession()) {
            return s.createQuery("from Product", Product.class).list();
        }
    }

    @Override
    public void update(Product p) {
        Transaction tx = null;
        try (Session s = getSession()) {
            tx = s.beginTransaction();
            s.update(p);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    @Override
    public void delete(Long id) {
        Transaction tx = null;
        try (Session s = getSession()) {
            tx = s.beginTransaction();
            Product p = s.get(Product.class, id);
            if (p != null) s.delete(p);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }
}
