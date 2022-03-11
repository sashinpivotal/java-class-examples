package com.test.hib.mapping.manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Department department1 = new Department();
        department1.setDname("IT");

        Department department2 = new Department();
        department2.setDname("HR");

        Teacher teacher1 = new Teacher();
        teacher1.setDep(department1);
        teacher1.setSalary("1000");
        teacher1.setTeacherName("MHaseeb");

        Teacher teacher2 = new Teacher();
        teacher2.setDep(department1);
        teacher2.setSalary("2220");
        teacher2.setTeacherName("Shahparan");

        Teacher teacher3 = new Teacher();
        teacher3.setDep(department1);
        teacher3.setSalary("30000");
        teacher3.setTeacherName("James");

        Teacher teacher4 = new Teacher();
        teacher4.setDep(department2);
        teacher4.setSalary("40000");
        teacher4.setTeacherName("Joseph");

        session.save(department1);
        session.save(department2);
        session.save(teacher1);
        session.save(teacher2);
        session.save(teacher3);
        session.save(teacher4);
        t.commit();
    }
}
