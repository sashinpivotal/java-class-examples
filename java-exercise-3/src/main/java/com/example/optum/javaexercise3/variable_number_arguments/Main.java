package com.example.optum.javaexercise3.variable_number_arguments;

public class Main {

    public static void main(String[] args) {
        printLines("sang", 1,2,3);
        printLines("shin", 1,2,3, 4,5);
        System.out.printf("");
    }

    public static void printLines(String name, int ...variableNumberOfArguments) {
        System.out.println(name);
        for (int x : variableNumberOfArguments) {
            System.out.println(x);
        }
    }


}


