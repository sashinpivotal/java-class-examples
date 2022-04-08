package com.example.springrestapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeRestController {

    private Employee employee;

    Map<Long, Employee> employees = new HashMap<>();

    public EmployeeRestController(Employee employee) {
        this.employee = employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") long id) {
        Employee employee = employees.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        Employee existingEmployee = employees.get(id);
        if (existingEmployee == null) {
            throw new EmployeeNotFoundException();
        }
        employees.replace(existingEmployee.getId(), employee);
        return employees.get(existingEmployee.getId());
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("name") long id) {
        employees.remove(id);
    }
}
