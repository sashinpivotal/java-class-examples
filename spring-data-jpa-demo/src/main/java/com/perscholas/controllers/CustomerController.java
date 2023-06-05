package com.perscholas.controllers;

import com.perscholas.entities.Customer;
import com.perscholas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/abc")
    public String getAllCustomers(Model model) {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/def")
    public String whatever() {
        return "xyz";
    }
}
