package com.test.hib.mapping.manyToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Teacher3")
public class Teacher3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tit;
    private String salary;
    private String Teachername;

    @ManyToMany(targetEntity = Cohort.class)
    private Set cohortSet;

    public Teacher3(String salary, String teachername, Set cohortSet) {
        this.salary = salary;
        this.Teachername = teachername;
        this.cohortSet = cohortSet;

    }

    public Teacher3() {
        super();
    }

    public Set getCohortSet() {
        return cohortSet;
    }

    public void setCohortSet(Set cohortSet) {
        this.cohortSet = cohortSet;
    }

    public int getTit() {
        return tit;
    }

    public void setTit(int tit) {
        this.tit = tit;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeachername() {
        return Teachername;
    }

    public void setTeachername(String teachername) {
        Teachername = teachername;
    }
}

