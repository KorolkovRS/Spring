package ru.korolkovrs.hibernate.crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBConnectionService {
    private static SessionFactory sessionFactory;

    private DBConnectionService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("configs/hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }
}