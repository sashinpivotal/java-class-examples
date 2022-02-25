package com.example.employee2;

public class Trainee extends Employee {

    public Trainee(long employeeId, String employeeName,
                   String employeeAddress, Long employeePhone,
                   double basicSalary) {
        super(employeeId, employeeName, employeeAddress, employeePhone);
        setBasicSalary(basicSalary);
    }
}
