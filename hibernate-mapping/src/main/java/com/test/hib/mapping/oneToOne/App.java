package com.test.hib.mapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        Address a1 = new Address();
        a1.setCity("nyc");
        a1.setState("NY");
        a1.setStreet("27th street");
        a1.setZipcode(11103);

        Address a2 = new Address();
        a2.setCity("Bufflo");
        a2.setState("NY");
        a2.setStreet("28th street");
        a2.setZipcode(15803);

        Person p1 = new Person();
        p1.setAge(25);
        p1.setEmail("e.jon@email.com");
        p1.setName("elbert Adam");
        p1.setAddress(a1);

        Person p2 = new Person();
        p2.setAge(45);
        p2.setEmail("ch.fink@email.com");
        p2.setName("Christ fink");
        p2.setAddress(a2);

        session.save(p1);
        session.save(p2);
        session.save(a1);
        session.save(a2);

        t.commit();
    }
}

