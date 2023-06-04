package com.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double salary;
    private String teacherName;

    public Teacher(double salary, String teacherName) {
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", salary=" + salary +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}

