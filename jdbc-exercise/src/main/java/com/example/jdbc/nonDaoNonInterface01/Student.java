package com.example.jdbc.nonDaoNonInterface01;

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
}
