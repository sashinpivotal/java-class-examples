package com.example.myfirstfullstack.controller;

import com.example.myfirstfullstack.models.Employee;
import com.example.myfirstfullstack.services.EmployeeNotFoundException;
import com.example.myfirstfullstack.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestEmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public RestEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        if (employeeById == null) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

}
