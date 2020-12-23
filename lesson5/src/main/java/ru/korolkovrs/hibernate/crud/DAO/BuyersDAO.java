package ru.korolkovrs.hibernate.crud.DAO;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.korolkovrs.hibernate.crud.DBConnectionService;
import ru.korolkovrs.hibernate.crud.models.Buyer;
import ru.korolkovrs.hibernate.crud.models.Product;

import java.util.List;

@Component
public class BuyersDAO {
    public List<Buyer> getAllBuyers() {
        List<Buyer> buyers;
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            buyers = session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
        }
        return buyers;
    }

    public Buyer getBuyerById(Long id) {
        Buyer buyer;
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
        }
        return buyer;
    }

    public void add(Buyer buyer) {
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(buyer);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Buyer buyer) {
        try (Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try(Session session = DBConnectionService.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }
}
