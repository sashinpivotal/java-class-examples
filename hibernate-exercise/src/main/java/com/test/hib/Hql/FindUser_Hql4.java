package com.test.hib.Hql;

import javax.persistence.TypedQuery;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

class App4 {
    public static void main( String[] args ) {
        FindUser_Hql4 u = new FindUser_Hql4();
        u.NamedParameterQuery();
    }
}

public class FindUser_Hql4 {

    public void NamedParameterQuery() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM User u WHERE u.id = :id";
        TypedQuery query = session.createQuery(hql);
        query.setParameter("id", 2);
        List<User> result = query.getResultList();

        for (User u : result) {
            System.out.println("User Id: " + u.getId() + "|"
                    + " Full name:" + u.getFullname() + "|"
                    + "Email: " + u.getEmail() + "|"
                    + "password: " + u.getPassword());
        }

        session.close();
        factory.close();

    }
}