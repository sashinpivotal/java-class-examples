package com.test.hib.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private String email;
    private String password;
    private int age;
    private double salary;
    private String city;

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public User() {
    }

    public User(String fullname, String email, String password, int age, double salary, String city) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.age =age;
        this.salary = salary;
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
