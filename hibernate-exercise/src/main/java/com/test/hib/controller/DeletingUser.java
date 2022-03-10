package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeletingUser {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        User u = new User();
        u.setId(3);
        session.delete(u);

        tx.commit();
        session.close();
        factory.close();
    }
}

