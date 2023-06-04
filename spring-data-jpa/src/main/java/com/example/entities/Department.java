package com.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departmentName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Teacher> teachers;

    public Department() {
    }

    public Department(String departmentName) {
        super();
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int did) {
        this.id = did;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String dname) {
        this.departmentName = dname;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teacherList) {
        this.teachers = teacherList;
    }
}

