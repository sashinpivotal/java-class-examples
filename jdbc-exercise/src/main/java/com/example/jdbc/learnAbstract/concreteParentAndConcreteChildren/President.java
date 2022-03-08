package com.example.jdbc.learnAbstract.concreteParentAndConcreteChildren;

public class President extends Employee{
    public President(String name) {
        super(name);
    }

    @Override
    public int calculateSalary() {
        return 1;
    }
}
