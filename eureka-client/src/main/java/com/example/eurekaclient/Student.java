package com.example.eurekaclient;

public class Student
{
    private  int id;
    private String name;
    private String className;

    public Student(String name, String className) {
        super();
        this.name = name;
        this.className = className;
    }
    public Student() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}

