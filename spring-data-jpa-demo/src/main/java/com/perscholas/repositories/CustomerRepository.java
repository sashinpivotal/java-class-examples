package com.perscholas.repositories;

import com.perscholas.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findFirstByName(String name);
    public List<Customer> findByName(String name);

    public List<Customer> findByNameAndAge(String name, int age);
}
