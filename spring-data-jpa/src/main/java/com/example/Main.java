package com.example;

import com.example.entities.Department;
import com.example.entities.Teacher;
import com.example.repository.DepartmentRepository;
import com.example.repository.TeacherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(Main.class, args);

        Department department = new Department("engineering");
        Teacher mary = new Teacher(2000.0, "mary2");
        Teacher tom = new Teacher(1000.0, "tom2");
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(mary);
        teachers.add(tom);
        department.setTeachers(teachers);

        DepartmentRepository departmentRepository
                = applicationContext.getBean(DepartmentRepository.class);
        Department department1 = departmentRepository.save(department);
        System.out.println(department1.getDepartmentName());
        System.out.println(department1.getTeachers());

        departmentRepository.delete(department1);
    }
}
