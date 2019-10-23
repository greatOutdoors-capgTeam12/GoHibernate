package com.capgemini.go.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.capgemini.go.entity.RetailerInventoryEntity;
import com.capgemini.go.util.HibernateUtil;

public class RetailerInventoryDao {
    public void saveProductDetails (RetailerInventoryEntity retInvEntity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory(RetailerInventoryEntity.class).openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(retInvEntity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List <RetailerInventoryEntity> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory(RetailerInventoryEntity.class).openSession()) {
            return session.createQuery("from RetailerInventoryEntity", RetailerInventoryEntity.class).list();
        }
    }
}