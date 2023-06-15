package com.test.hib.mapping.oneToMany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Department2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    private String dname;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Teacher2> teacherList;

    public Department2(int did, String dname) {
        super();
        this.did = did;
        this.dname = dname;
    }

    public Department2() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Teacher2> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher2> teacherList) {
        this.teacherList = teacherList;
    }
}

