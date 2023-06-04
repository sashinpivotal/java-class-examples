package com.example;

import com.example.entities.Teacher;
import com.example.repository.TeacherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(Main.class, args);

        TeacherRepository teacherRepository
                = applicationContext.getBean(TeacherRepository.class);
        teacherRepository.save(new Teacher(1000.0, "sang shin"));
        List<Teacher> teachers = teacherRepository.findAll();
        System.out.println(teachers);
    }
}
