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
    private String dname;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Teacher> teacherList;

    public Department(int id, String dname) {
        super();
        this.id = id;
        this.dname = dname;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int did) {
        this.id = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}

