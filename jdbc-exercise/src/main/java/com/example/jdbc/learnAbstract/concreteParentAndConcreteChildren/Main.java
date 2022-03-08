package com.example.jdbc.learnAbstract.concreteParentAndConcreteChildren;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(
                Arrays.asList(new Manager("sang")
                        , new Manager("tony")
                        , new Trainee("mary")
                        , new President("joe")));

        employees.forEach(employee -> {
            int salary = employee.calculateSalary();
            System.out.println("name " + employee.getEmployeeInfo()
                    + "salary " + salary);
        });
    }
}
