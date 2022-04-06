package com.example.myfirstfullstack.services;

import com.example.myfirstfullstack.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployServiceImpl2 implements EmployeeService {

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(long id) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

    @Override
    public void deleteEmployeeById(long id) {

    }
}
