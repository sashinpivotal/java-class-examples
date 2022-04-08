package com.example.springrestapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeRestController {

    private Employee employee;

    Map<String, Employee> employees = new HashMap<>();

    public EmployeeRestController(Employee employee) {
        this.employee = employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }

    @GetMapping("/employees/{name}")
    public Employee getEmployee(@PathVariable("name") String name) {
        return employees.get(name);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employees.put(employee.getName(), employee);
    }

    @PutMapping("/employees/{name}")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employees.replace(employee.getName(), employee);
        return employees.get(employee.getName());
    }

    @DeleteMapping("/employees/{name}")
    public void deleteEmployee(@PathVariable("name") String name) {
        employees.remove(name);
    }
}
