package com.example.junitexercise;

import java.util.Locale;

public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getStudentInfo() {
        return getName() + " is " + getAge() + " years old";
    }

    public String retrieveStdudentNameInUpperCase() {
        return getName().toUpperCase();
    }

    public void updateName(String updateName) {

        if (updateName.length() < 4) {
            throw new NameSizeIncorrectException();
        }

    }

    // add a method that returns student name in uppercase

}
