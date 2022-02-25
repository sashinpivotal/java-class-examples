package com.example.employee2;

public class Employee {

    private long employeeId;
    private String employeeName;
    private String employeeAddress;
    private Long employeePhone;
    private double basicSalary;
    private double specialAllowance = 250.80;
    private double hra = 1000.50;

    public Employee(long employeeId, String employeeName, String employeeAddress, Long employeePhone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
    }

    public double calculateSalary() {
        double salary = basicSalary
                + (get10percentOfBasicSalary(basicSalary, specialAllowance) / 100)
                + (get10percentOfBasicSalary(basicSalary, hra) / 100);
        System.out.println("salary from Employee class: " + salary);
        return salary;
    }

    public double calculateTransportAllowance() {
        return get10percentOfBasicSalary(10.0 / 100.0, basicSalary);
    }

    private double get10percentOfBasicSalary(double v, double basicSalary) {
        return v * basicSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

}
