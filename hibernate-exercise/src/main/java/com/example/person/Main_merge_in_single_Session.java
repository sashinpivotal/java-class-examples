package com.example.person;

import com.example.person.utilities.HibernateUtil;
import com.example.person.model.Person;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main_merge_in_single_Session {

    public static void main(String[] args) {

        // Set up database tables
        HibernateUtil.droptable("drop table people");
        HibernateUtil.setup("create table people ( id int, name VARCHAR(20))");

        // Create SessionFactory and Session object
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        Person p1 = null;
        Person p2 = null;
        Person p1_merged = null;

        Object id1 = null;
        Object id2 = null;

        // Perform life-cycle operations under a transaction
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Create a Person object and save it
            p1 = new Person();  //transient state
            p1.setName("Exo");
            // Persist the given transient instance, first assigning a 
            // generated identifier.
            session.save(p1);          // persistent state

            id1 = session.getIdentifier(p1);
            System.out.println("Session 1, id1 = " + id1);

            // Create another Person object and save it.
            p2 = new Person();  //transient state
            p2.setName("Blackpink");
            session.save(p2);          // persistent state

            id2 = session.getIdentifier(p2);
            System.out.println("Session 1, id2 = " + id2);

            boolean dirty = session.isDirty();
            System.out.println("Session is dirty before commit: " + dirty);
            System.out.println("About to perform commit...");
            tx.commit();
            System.out.println("After commit...");
            dirty = session.isDirty();
            System.out.println("Session is dirty after commit: " + dirty);

            // Start the 2nd transaction in the same session
            tx = session.beginTransaction();
            
            // p1 is still in persistent state since it still
            // has a session it is associated with.
            p1.setName("Exo2");
            // Since p1 is still a persistence object, there is
            // no need to load it from the database table.
            // So you will not see SQL.
            System.out.println("About to perform merge...");
            p1_merged = (Person) session.merge(p1);          
            System.out.println("After the merge....");

            id1 = session.getIdentifier(p1_merged);
            System.out.println("Session 2, id1 = " + id1);

            // p2 is still in persistent state since it still
            // has a session it is associated with.
            p2.setName("Blackpink2");
            session.save(p2);          
            id2 = session.getIdentifier(p2);
            System.out.println("Session 2, id2 = " + id2);
            
            System.out.println("About to perform commit...");
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

        // p1 and p2 are now in detached state
        // You will experience "Session/EntityManager is closed"
        // exception in the following statements.
        // id1 = session.getIdentifier(p1);
        // boolean dirty = session.isDirty();

        // Display tables
        HibernateUtil.checkData("select * from people");

    }
}
