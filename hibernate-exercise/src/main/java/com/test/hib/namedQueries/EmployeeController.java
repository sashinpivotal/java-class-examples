package com.test.hib.namedQueries;

import com.test.hib.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeController {
    public void createEmployeeTable() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();
        Employee uone = new Employee();
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}

class App {
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        EmployeeController e = new EmployeeController();
        e.createEmployeeTable();
    }
}

