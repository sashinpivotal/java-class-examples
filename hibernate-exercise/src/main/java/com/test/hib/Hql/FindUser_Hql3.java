package com.test.hib.Hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

class App3 {
    public static void main( String[] args ) {
        FindUser_Hql3 u = new FindUser_Hql3();
        u.getmaxSalary();
    }
}

public class FindUser_Hql3 {
    public void getmaxSalary() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT Max(U.salary) FROM User U";
        Query query = session.createQuery(hql);
        double maxSalary = (Double) query.getSingleResult();
        System.out.println("Maximum salary: " + maxSalary);

        String hql2 = "SELECT COUNT(*) FROM User U";
        List results = session.createQuery(hql2).getResultList();
        System.out.println("number of rows: " + results);

    }
}
