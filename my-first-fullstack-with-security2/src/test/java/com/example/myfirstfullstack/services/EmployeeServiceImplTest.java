package com.example.myfirstfullstack.services;

import com.example.myfirstfullstack.models.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        Employee employee = new Employee();
        employee.setLastName("Jones");
        employee.setFirstName("Tom");
        employee.setEmail("tom.jones@gmail.com");
        employeeService.saveEmployee(employee);
    }

    @Test
    void getAllEmployees() {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        int beforeAddingMoreEmployees = allEmployees.size();

        Employee employee2 = new Employee();
        employee2.setLastName("Jones2");
        employee2.setFirstName("Tom2");
        employee2.setEmail("tom.jones@gmail.com2");
        employeeService.saveEmployee(employee2);
        int afterAddingMoreEmployees = employeeService.getAllEmployees().size();

        Assertions.assertThat(afterAddingMoreEmployees).isEqualTo(beforeAddingMoreEmployees + 1);
    }

    @Test
    void saveEmployee() {
        double random = Math.random();
        String randomLastName = "Jones" + random;
        String randomEmail = "tom.jones" + random + "@gmail.com";
        Employee employee = new Employee("Tom", randomLastName, randomEmail);

        employeeService.saveEmployee(employee);

        List<Employee> allEmployees = employeeService.getAllEmployees();
        Assertions.assertThat(allEmployees.contains(employee));
    }

    @Test
    void getEmployeeById() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        Employee employee1 = allEmployees.get(0);
        if (employee1 != null) {
            Employee employee2 = employeeService.getEmployeeById(employee1.getId());
            Assertions.assertThat(employee1).isEqualTo(employee2);
        }
    }
}