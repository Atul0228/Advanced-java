package com.demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sf;

    static {
        try {
            sf = new Configuration().configure().buildSessionFactory();
        } catch (Throwable t) {
            System.err.println("Initial SessionFactory creation failed: " + t);
            throw new ExceptionInInitializerError(t);
        }
    }

    public static SessionFactory getSf() {
        return sf;
    }

    public static void shutdown() {
        if (sf != null) sf.close();
    }
}
