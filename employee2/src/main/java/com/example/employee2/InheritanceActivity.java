package com.example.employee2;

public class InheritanceActivity {
    public static void main(String[] args) {
        Employee employee = new Manager(126534, "Peter",
                "Chennai India", 237844L,
                65000);
        System.out.println("manager salary is " + employee.calculateSalary());
        System.out.println("manager travel allowance is "
                + employee.calculateTransportAllowance());

        Employee employee2 = new Trainee(29864, "Jack",
                "Mumbai India", 442085L,
                45000);
        double salary1 = employee2.calculateSalary();
        System.out.println("trainee salary is " + salary1);
        System.out.println("trainee travel allowance is "
                + employee2.calculateTransportAllowance());
    }
}
