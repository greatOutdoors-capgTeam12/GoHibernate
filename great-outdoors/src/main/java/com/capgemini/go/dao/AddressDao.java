package com.capgemini.go.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.capgemini.go.entity.AddressEntity;
import com.capgemini.go.util.HibernateUtil;

public class AddressDao {
    public void saveAddress (AddressEntity addressEntity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory(AddressEntity.class).openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(addressEntity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List <AddressEntity> getAddress() {
        try (Session session = HibernateUtil.getSessionFactory(AddressEntity.class).openSession()) {
            return session.createQuery("from AddressEntity", AddressEntity.class).list();
        }
    }
}