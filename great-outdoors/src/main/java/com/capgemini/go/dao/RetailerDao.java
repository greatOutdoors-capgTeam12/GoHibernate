package com.capgemini.go.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capgemini.go.entity.RetailerInventoryEntity;
import com.capgemini.go.entity.WishlistEntity;
import com.capgemini.go.util.HibernateUtil;

public class RetailerDao {
    public void Wishlist (WishlistEntity wishEntity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
           
            session.save(wishEntity);
           
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List <WishlistEntity> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from WishlistEntity", WishlistEntity.class).list();
        }
    }
}