package com.example.jdbc.nonDaoNonInterface01;

import java.util.List;

public class NonDaoMain {
    public static void main(String[] args) {
        StudentDaoImpl studentDaoI = new StudentDaoImpl();

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

        TeacherDaoI teacherDaoI = new TeacherDaoImpl();

        List<Teacher> allTeachers = teacherDaoI.getAllTeachers();
        allTeachers.forEach(teacher
                -> System.out.println("teacher info: "
                + teacher.getEmail() + " "
                + teacher.getfName() + " "
                + teacher.getlName()));

        Teacher teacher = teacherDaoI.getTeacherById(1);
        System.out.println("Teacher 1: "
                + teacher.getEmail() + " "
                + teacher.getfName() + " "
                + teacher.getlName());
    }
}
