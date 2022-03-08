package com.example.jdbc.learnAbstract.concreteParentAndConcreteChildren;

public class Manager extends Employee {
    private String department;

    public Manager(String name) {
        super(name);
    }

    @Override
    public int calculateSalary() {
        return 10000;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManagerInfo() {
        return department;
    }
}
