package com.example.lambdaexercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main3 {

    public static void main(String[] args) {

        Integer[] myArray = {3, 9, 8, 5, 4};
        for (Integer i : myArray) {
            System.out.println(i);
        }

        // refactor the above code to use forEach of List and Lambda
        Arrays.asList(myArray).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        // Use streams to print only the even numbers
        Arrays.asList(myArray).stream()
                .filter(number -> number%2 == 0)
                .forEach(number-> System.out.println(number));
    }
}
