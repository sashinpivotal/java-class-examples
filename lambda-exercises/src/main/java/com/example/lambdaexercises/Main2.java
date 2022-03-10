package com.example.lambdaexercises;

public class Main2 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is from annoy code");
            }
        };

        Runnable runnable2 = () -> System.out.println("This is from Lambda");
        runnable2.run();
    }
}
