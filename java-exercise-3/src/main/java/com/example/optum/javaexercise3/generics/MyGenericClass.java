package com.example.optum.javaexercise3.generics;

public class MyGenericClass <T extends Number>{

    private T myType;

    public T getMyType() {
        return myType;
    }

    public void setMyType(T myType) {
        this.myType = myType;
    }
}
