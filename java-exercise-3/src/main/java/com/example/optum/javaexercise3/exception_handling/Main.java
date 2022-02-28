package com.example.optum.javaexercise3.exception_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args)  {
        method1();
    }

    private static void method1()  {
        try {
            method2();
        } catch (FileNotFoundException fileNotFoundException) {
            throw new SomethingIsNotFoundException();
        }

    }

    private static void method2() throws FileNotFoundException{
        method3();
    }

    private static void method3() throws FileNotFoundException {

        // option #1
//        try {
//            File file = new File("/Users/sang/tmp/xyz");
//            FileReader fileReader = new FileReader(file);
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.out.println(fileNotFoundException.getStackTrace());
//        }

        File file = new File("/Users/sang/tmp/xyz");
        FileReader fileReader = new FileReader(file);

    }
}
