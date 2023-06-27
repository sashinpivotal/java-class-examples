package com.example.eurekaclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentServiceController {
    @GetMapping("/liststudent/{classname}")
    public List<Student> getStudents1(@PathVariable String classname) {
        String classnames = classname;
        // Assume that below list of student is coming from Database, later you can convert this into Spring Data Rest
        ArrayList<Student> schooDB = new ArrayList<Student>();
        List<Student> lst = new ArrayList<Student>();
        Student std1 = new Student("Adam", classnames);
        Student std2 = new Student("Tom", classnames);
        Student std3 = new Student("Fink", classnames);
        Student std4 = new Student("James", classnames);

        lst.add(std1);
        lst.add(std2);
        lst.add(std3);
        lst.add(std4);
        return lst;
    }
}

