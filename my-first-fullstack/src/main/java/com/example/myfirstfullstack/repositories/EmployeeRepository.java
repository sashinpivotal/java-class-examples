package com.example.myfirstfullstack.repositories;

import com.example.myfirstfullstack.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findFirstByLastName(String firstName);
}
