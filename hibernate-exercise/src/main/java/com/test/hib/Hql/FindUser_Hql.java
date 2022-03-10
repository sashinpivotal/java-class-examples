package com.test.hib.Hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.test.hib.model.User;

import javax.persistence.TypedQuery;

class App {
    public static void main( String[] args ) {
        FindUser_Hql u = new FindUser_Hql();
        u.findUser();
    }
}

public class FindUser_Hql {

    public void findUser() {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM User";
        TypedQuery query = session.createQuery(hql);
        List<User> results = query.getResultList();

        for (User u : results) {
            System.out.println("User Id: " + u.getId() + "|"
                    + " Full name: " + u.getFullname() +" | "
                    + " Email: " + u.getEmail() +" | "
                    + " password " + u.getPassword());
        }
    }
}
