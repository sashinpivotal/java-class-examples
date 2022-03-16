package com.example.jdbc.daoAndUseInterface03;

import java.util.Objects;

public class Student {
    private int id;
    private String email;
    private String fName;
    private String lName;

    public Student(int id, String email, String fName, String lName) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(email, student.email) && Objects.equals(fName, student.fName) && Objects.equals(lName, student.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, fName, lName);
    }
}
