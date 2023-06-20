package com.example.myfirstfullstack.repositories;

import com.example.myfirstfullstack.models.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findFirstByLastName_should_return_Employee_given_valid_lastname() {

        Employee jones = employeeRepository.findFirstByLastName("Jones");
        Assertions.assertThat(jones.getLastName()).isEqualTo("Jones");
    }
}