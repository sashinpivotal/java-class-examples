package com.example.springbeandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeanDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(SpringBeanDemoApplication.class, args);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }

}
