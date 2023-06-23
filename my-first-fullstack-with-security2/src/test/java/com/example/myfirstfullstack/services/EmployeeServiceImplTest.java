package com.example.myfirstfullstack.services;

import com.example.myfirstfullstack.models.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

// Using @SpringBootTest to create application context
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        Employee employee
                = new Employee("Jones", "Tom", "tom.jones@gmail.com");
        employeeService.saveEmployee(employee);
    }

    @Test
    void getAllEmployees_should_return_all_employees() {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        int beforeAddingMoreEmployees = allEmployees.size();

        Employee employee2
                = new Employee("Jones2", "Tom2", "tom.jones2@gmail.com");
        employeeService.saveEmployee(employee2);
        int afterAddingMoreEmployees = employeeService.getAllEmployees().size();

        Assertions.assertThat(afterAddingMoreEmployees).isEqualTo(beforeAddingMoreEmployees + 1);
    }

    @Test
    void saveEmployee_with_valid_data_should_save_it_successfully() {
        double random = Math.random();
        String randomLastName = "Jones" + random;
        String randomEmail = "tom.jones" + random + "@gmail.com";
        Employee employee = new Employee("Tom", randomLastName, randomEmail);

        employeeService.saveEmployee(employee);

        List<Employee> allEmployees = employeeService.getAllEmployees();
        Assertions.assertThat(allEmployees.contains(employee));
    }

    @Test
    void getEmployeeById_with_valid_id_should_return_valid_employee() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        Employee employee1 = allEmployees.get(0);
        if (employee1 != null) {
            Employee employee2 = employeeService.getEmployeeById(employee1.getId());
            Assertions.assertThat(employee1).isEqualTo(employee2);
        }
    }
}