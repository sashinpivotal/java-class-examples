package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdatingUser {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        User u = new User();
        u.setId(3);
        u.setEmail("sang@perscholas.com");
        u.setFullname("Sang SHin2");
        u.setPassword("123456");
        session.merge(u);

        // Returns true only when value of a field is changed
        System.out.println("session dirty2? " + session.isDirty());

        session.getTransaction().commit();
        session.close();
    }
}

