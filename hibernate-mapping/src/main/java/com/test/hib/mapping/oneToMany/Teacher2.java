package com.test.hib.mapping.oneToMany;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Teacher2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String salary;
    private String teacherName;

    public Teacher2(int id, String salary, String teachername) {
        this.id = id;
        this.salary = salary;
        teacherName = teachername;
    }

    public Teacher2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

