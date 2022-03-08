package com.example.jdbc.daoAndUseInterface03;

import java.util.List;

public class DaoMain {
    public static void main(String[] args) {
        StudentDaoI studentDaoI = new StudentDaoImpl();

        List<Student> allStudents = studentDaoI.getAllStudents();
        allStudents.forEach(student
                -> System.out.println("student info: "
                                    + student.getEmail() + " "
                                    + student.getfName() + " "
                                    + student.getlName()));

        Student student = studentDaoI.getStudentById(1);
        System.out.println("Student 1: "
                + student.getEmail() + " "
                + student.getfName() + " "
                + student.getlName());
    }
}
