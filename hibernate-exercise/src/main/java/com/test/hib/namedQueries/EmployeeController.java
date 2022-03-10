package com.test.hib.namedQueries;

import com.test.hib.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

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

    public void populateEmployeeTable() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        String nativeSQL =
                "INSERT INTO `mydb`.`employee` (`addressLine`, `city`, `job`, `name`, `officeCode`, `salary`, `startDate`, `zipcode`) VALUES \n" +
                        "('24-10', 'NYC', 'Ceo', 'Tom Thele', 1, '25600', '2021-09-09 18:32:11.000000', '11102'),\n" +
                        "('35-16', 'LA', 'Manager', 'Jenny Ji', 2, '15600', '2021-09-09 18:32:11.000000', '11103'),\n" +
                        "('34-10', 'NJ', 'Cfo', 'M Joseph', 3, '16600', '2021-09-09 18:32:11.000000', '11583'),\n" +
                        "('44-20', 'NYC', 'Manager', 'James Judge', 4, '185600', '2021-09-09 18:32:11.000000', '18983'),\n" +
                        "('44-20', 'Dallas', 'Manager', 'Ramon Rio', 5, '36600', '2021-09-09 18:32:11.000000', '14783'),\n" +
                        "('44-40', 'LA', 'Manager', 'James Santana', 6, '78600', '2021-09-09 18:32:11.000000', '18483'),\n" +
                        "('484-40', 'LA', 'Manager', 'Elded Oreo', 6, '50089', '2021-09-09 18:32:11.000000', '155483')";
        NativeQuery nativeQuery = session.createSQLQuery(nativeSQL);
        nativeQuery.executeUpdate();

        t.commit();
        System.out.println("successfully populated");
        factory.close();
        session.close();
    }

    public void findEmployeeByname() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//------------  Hibernate Named Query   -------------
        TypedQuery query = session.getNamedQuery("findEmployeeByName");
        query.setParameter("name", "Tom Thele");
        List<Employee> employees = query.getResultList();
        Iterator<Employee> itr = employees.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            System.out.println(e);
        }
        factory.close();
        session.close();
    }

    public void findEmployeeById() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//------------  Hibernate Named Query   -------------
        TypedQuery query = session.getNamedQuery("get_Emp_name_by_id");
        query.setParameter("id", 3);
        List<Object[]> emName = query.getResultList();

        for (Object[] o : emName) {
            System.out.println("Employee name: " + o[0]
                    + " | Employee Salary: " + o[1]
                    + " | Emp Job Title: " + o[2]);
        }

        factory.close();
        session.close();
    }

    public void ShowOfficeCodes_AsDepartment() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//------------  Hibernate Named Query   -------------
        TypedQuery query = session.getNamedQuery("empDepAlias");
        List<Object[]> list = query.getResultList();
        for (Object[] e : list) {
            System.out.println("OfficeCode: " + e[1] + " | Dep Name: " + e[3] + " | Employee Name: " + e[2]);
        }
        factory.close();
        session.close();
    }
}


class App {
    public static void main(String[] args) {
        EmployeeController e = new EmployeeController();
        e.createEmployeeTable();
        e.populateEmployeeTable();
        e.findEmployeeByname();
    }
}

