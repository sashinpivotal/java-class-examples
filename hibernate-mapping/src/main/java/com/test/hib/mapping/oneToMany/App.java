package com.test.hib.mapping.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        Teacher2 t1 = new Teacher2();
        t1.setTeacherName("Haseeb");
        t1.setSalary("100");

        Teacher2 t2 = new Teacher2();
        t2.setTeacherName("Jenny Finch");
        t2.setSalary("10000");

        Teacher2 t3 = new Teacher2();
        t3.setTeacherName("James");
        t3.setSalary("25000");

        Teacher2 t4 = new Teacher2();
        t4.setTeacherName("SID ROSE");
        t4.setSalary("3000");

        Teacher2 t5 = new Teacher2();
        t5.setSalary("200");
        t5.setTeacherName("Ali");

        //Add teacher entity object to the list
        List<Teacher2> teachlist = new ArrayList();
        teachlist.add(t1);
        teachlist.add(t2);
        teachlist.add(t3);
        teachlist.add(t4);
        teachlist.add(t5);
        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);
        session.save(t5);

        //Create Department
        Department2 department = new Department2();
        department.setDname("Development");
        department.setTeacherList(teachlist);

        //Store Department
        session.save(department);
        t.commit();
    }
}
