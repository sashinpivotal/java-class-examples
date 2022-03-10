package com.example.person;

import com.example.person.model.Person;
import com.example.person.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_save_with_transient_state_object {

    public static void main(String[] args) {

        // Set up database tables
        HibernateUtil.droptable("drop table if exists people");
        HibernateUtil.setup("create table people ( id int, name VARCHAR(20))");

        // Create SessionFactory and Session object
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        // Perform life-cycle operations under a transaction
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Create a Person object
            Person p1 = new Person();  //transient state
            p1.setName("Lady Gaga");

            // Persist the given transient instance via save() method.
            // The object identifier that is assigned by Hibernate will be
            // returned.
            Object id1 = session.save(p1);          // persistent state

            // You can get the object identifier through getIdentifier() method.
            // Object id1 = session.getIdentifier(p1);
            System.out.println("id1 = " + id1);

            // Create another Person object and persist it.
            Person p2 = new Person();  // transient state
            p2.setName("BTS");
            // Comment out the following 3 lines of code and note
            // that the "p2" remains as a transient instance. Since
            // it is a transient instance, it will not be committed
            // to the database table.
//            session.save(p2);          // persistent state
//            Object id2 = session.getIdentifier(p2);
//            System.out.println("id2 = " + id2);

            boolean dirty = session.isDirty();
            System.out.println("Session is dirty: " + dirty);
            System.out.println("About to commit... Expect to see SQL requests");

            // Expect to see SQL requests
            tx.commit();
            System.out.println("After commit...");

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Display tables
        HibernateUtil.checkData("select * from people");

    }
}
