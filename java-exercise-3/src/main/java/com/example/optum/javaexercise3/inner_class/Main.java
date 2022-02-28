package com.example.optum.javaexercise3.inner_class;

public class Main {

    public static void main(String[] args) {

        // Creating inner class object (non-static nested class)
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        String myString = innerClass.myInnerMethod();
        System.out.println(myString);

        // How to invoke static method from static nested class
        String s2 = OuterClass.StaticNestedClass.myStaticNestedMethod();
        System.out.println(s2);
    }
}
