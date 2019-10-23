package com.capgemini.go.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.capgemini.go.entity.AddressEntity;
import com.capgemini.go.util.HibernateUtil;

public class AddressDao {
    public void saveAddress (AddressEntity addressEntity) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(addressEntity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
        	session.close();
        }
    }
    
    public List <AddressEntity> getAddress() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from AddressEntity", AddressEntity.class).list();
        }
    }
}