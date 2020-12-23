package ru.korolkovrs.hibernate.crud.DAO;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.korolkovrs.hibernate.crud.DBConnectionService;
import ru.korolkovrs.hibernate.crud.models.Product;

import java.util.List;

@Component
public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products;
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
        }
        return products;
    }

    public Product getProductById(Long id) {
        Product product;
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    public void add(Product product) {
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Product product) {
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try(Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public
}
