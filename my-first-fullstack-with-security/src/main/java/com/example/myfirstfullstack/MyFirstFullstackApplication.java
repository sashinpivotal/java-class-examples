package com.example.myfirstfullstack;

import com.example.myfirstfullstack.controller.EmployeeController;
import com.example.myfirstfullstack.services.DummyService;
import com.example.myfirstfullstack.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MyFirstFullstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstFullstackApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeService employeeService) {
        return args -> System.out.println("My application got started!!");
    }

}
