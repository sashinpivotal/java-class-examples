package com.example.myfirstfullstack.services;

import com.example.myfirstfullstack.models.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        // arrange

        // act and assert
        List<Employee> allEmployees = employeeService.getAllEmployees();
        int beforeAddingMoreEmployees = allEmployees.size();

        Employee employee1 = new Employee();
        employee1.setLastName("Jones");
        employee1.setFirstName("Tom");
        employee1.setEmail("tom.jones@gmail.com");
        employeeService.saveEmployee(employee1);
        int afterAddingMoreEmployees = employeeService.getAllEmployees().size();

        Assertions.assertThat(afterAddingMoreEmployees).isEqualTo(beforeAddingMoreEmployees + 1);
        Assertions.assertThat(allEmployees.contains(employee1));

        // verify
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