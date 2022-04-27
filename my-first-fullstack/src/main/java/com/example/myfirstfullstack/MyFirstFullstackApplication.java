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

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class MyFirstFullstackApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyFirstFullstackApplication.class, args);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        if (employeeService != null) {
            System.out.println("employService = " + employeeService);
        }
        EmployeeController employeeController = applicationContext.getBean(EmployeeController.class);
        if (employeeController != null) {
            System.out.println("employeeController = " + employeeController);
        }

        try {
            applicationContext.getBean(DummyService.class);
        } catch (Exception e) {
            System.out.println("dummyService bean not found");
        }
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeService employeeService) {
        return args -> System.out.println("My application got started!!");
    }

    @Bean
    public CommandLineRunner commandLineRunner2() {
        return args -> System.out.println("My application got started!!");
    }

}
