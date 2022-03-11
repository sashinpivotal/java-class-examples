package com.test.hib.mapping.oneToOne;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    private String name;
    private String email;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Person(int personId, String name, String email, int age) {
        super();
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Person() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address adress) {
        this.address = adress;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

