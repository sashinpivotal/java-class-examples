package com.example.lambdaexercises;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello";
        String suppliedString = supplier.get();
        System.out.println(suppliedString);

        Supplier<Integer> supplier2 = () -> 34;
        Integer integer = supplier2.get();
        System.out.println(integer);

        Consumer<Integer> myConsumer = x -> System.out.println(x);
        myConsumer.accept(340);
        BiConsumer<Integer, String> biConsumer
                = (x, y) -> System.out.println(x + " " + y);
        biConsumer.accept(45, "sang");

        Function<Integer, String> function
                = x -> x.toString();
        String result = function.apply(67);
        System.out.println(result);

        Predicate<Integer> predicate = x -> x > 10;
        boolean test = predicate.test(3);
        System.out.println(test);
    }
}

