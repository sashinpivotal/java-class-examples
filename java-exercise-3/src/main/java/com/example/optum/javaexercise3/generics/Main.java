package com.example.optum.javaexercise3.generics;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // example code you are NOT using Generics
        MyLongClass myLong = new MyLongClass();
        myLong.getaLong();

        MyIntegerClass myInteger = new MyIntegerClass();
        myInteger.getInteger();

        // example code that you are leveraging Generics
        MyGenericClass<Integer> integerMyGenericClass
                = new MyGenericClass<>();
        integerMyGenericClass.getMyType();

        MyGenericClass<Long> longMyGenericClass
                = new MyGenericClass<>();
        longMyGenericClass.getMyType();

//        MyGenericClass<Boolean> booleanMyGenericClass
//                = new MyGenericClass<>();
//
//        new MyGenericClass<String>();

        ArrayList<Integer> myArrayList = new ArrayList<>();
        HashSet<String> myHashSet = new HashSet<>();
    }
}
