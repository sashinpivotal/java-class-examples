package com.test.hib.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table
//Using @NamedQuery for single  HQL
@NamedQuery(name = "getallEmployee", query = "select e from Employee e")

//Using @NamedQueries for multiple  HQL
@NamedQueries({
        @NamedQuery(name = "get_Emp_name_by_id", query = "select e.name,e.salary,e.job from Employee e where id=:id"),
        @NamedQuery(name = "get_all_dept", query = "from Employee"),
        @NamedQuery(name = "findEmployeeByName", query = "from Employee e where e.name = :name"),
        @NamedQuery(name = "empDepAlias", query = "select e, e.officeCode , e.name, "
                + "CASE "
                + "When (e.officeCode = 1) THEN 'IT'"
                + "WHEN (e.officeCode = 6) THEN 'Admin'"
                + "WHEN (e.officeCode = 5) THEN 'HR'"
                + "WHEN (e.officeCode = 4) THEN 'Developers'"
                + "WHEN (e.officeCode = 3) THEN 'Accounts'"
                + "WHEN (e.officeCode = 2) THEN 'Finanace'"
                + "ELSE 'General' END FROM Employee e  "),
})

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    private String job;
    private String addressLine;
    private String zipcode;
    private String city;
    private Date startDate;
    private int officeCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(int officeCode) {
        this.officeCode = officeCode;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", " +
                "name=" + name + ", " +
                "salary=" + salary + ", " +
                "job=" + job + ", " +
                "addressLine=" + addressLine + ", " +
                "zipcode=" + zipcode + ", " +
                "city = " + city + ", " +
                "startDate = " + startDate + "]";
    }
}
