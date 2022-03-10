package com.example.person.model;

import javax.persistence.*;
import java.io.Serializable;

// Person domain class
@Entity
@Table(name="PEOPLE")
public class Person implements Serializable {

    // Id field
    private int id;
    private String name;

    // No arg constructor
    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter method of id field
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    // Setter method of id field
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
