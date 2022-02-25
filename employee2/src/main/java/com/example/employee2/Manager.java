package com.example.employee2;

public class Manager extends Employee{

    public Manager(long employeeId, String employeeName,
                   String employeeAddress, Long employeePhone,
                   double basicSalary) {
        super(employeeId, employeeName, employeeAddress, employeePhone);
        setBasicSalary(basicSalary);
    }

    @Override
    public double calculateTransportAllowance() {
        return 15 * getBasicSalary() / 100;
    }
}
