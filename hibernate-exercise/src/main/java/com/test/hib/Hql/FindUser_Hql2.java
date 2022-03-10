package com.test.hib.Hql;

import com.test.hib.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

class App2 {
    public static void main( String[] args ) {
        FindUser_Hql2 u = new FindUser_Hql2();
        u.getRecordbyId();
    }
}

public class FindUser_Hql2 {

    public void getRecordbyId() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT U FROM User U WHERE U.id < 5 ORDER BY U.id DESC";
        TypedQuery query = session.createQuery(hql);
        List<User> list  =  query.getResultList();

        for (User u : list) {
            System.out.println("User Id: " + u.getId() + "|"
                    + " Full name:" + u.getFullname() +"|"
                    + "Email: " + u.getEmail() +"|"
                    + "password" + u.getPassword());
        }
    }

}

