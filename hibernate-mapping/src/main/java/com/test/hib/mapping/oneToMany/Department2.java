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

    @OneToMany(targetEntity = Teacher2.class, cascade = {CascadeType.ALL})
    private List teacherList;

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

    public List getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List teacherList) {
        this.teacherList = teacherList;
    }
}

