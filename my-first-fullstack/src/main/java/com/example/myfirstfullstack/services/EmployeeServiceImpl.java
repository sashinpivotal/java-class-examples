package com.example.myfirstfullstack.services;

import com.example.myfirstfullstack.models.Employee;
import com.example.myfirstfullstack.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private Employee employee;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    /**
     * Returns an Employee object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an employee
     * @return      Employee object
     */
    @Override
    public Employee getEmployeeById(long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee getEmployeeByName(String name) {
        Employee employee = employeeRepository.findFirstByLastName(name);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }
}
