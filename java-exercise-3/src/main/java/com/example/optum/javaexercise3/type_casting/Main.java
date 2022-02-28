package com.example.optum.javaexercise3.type_casting;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new EnglishMajor();
        Student student3 = new MathMajor();

        // --------- No compile error but runtime error
//        MathMajor mathMajor1 = (MathMajor) student1;
//        MathMajor mathMajor2 = (MathMajor) student2;

        // --------- No compile error and no runtime error
//        MathMajor mathMajor3 = (MathMajor) student3;
//
//        student3.getStudent();
//        student3.getMathMajor();
//        ((MathMajor)student3).getMathMajor();

        // --------- No compile error but runtime error
//        ((MathMajor)student2).getMathMajor(); // runtime error

        // --------- Use instanceof to avoid runtime error
        if (student2 instanceof MathMajor) {
            ((MathMajor)student2).getMathMajor();
        } else if (student2 instanceof EnglishMajor) {
            ((EnglishMajor)student2).getEnglishMajor();
        }

    }
}
