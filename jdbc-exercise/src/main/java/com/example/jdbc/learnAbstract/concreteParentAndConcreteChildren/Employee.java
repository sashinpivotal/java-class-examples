package com.example.jdbc.learnAbstract.concreteParentAndConcreteChildren;

public abstract class Employee {

    private String employName;

    public Employee(String name) {
        this.employName = name;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public String getEmployeeInfo() {
        return "employee name is" + employName;
    }

    public abstract int calculateSalary();
}
