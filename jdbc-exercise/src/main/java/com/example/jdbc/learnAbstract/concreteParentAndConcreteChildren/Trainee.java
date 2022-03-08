package com.example.jdbc.learnAbstract.concreteParentAndConcreteChildren;

public class Trainee extends Employee {

    private int numberOfYearsToTrain;

    public Trainee(String name) {
        super(name);
    }

    @Override
    public int calculateSalary() {
        return 500;
    }

    public int getNumberOfYearsToTrain() {
        return numberOfYearsToTrain;
    }

    public void setNumberOfYearsToTrain(int numberOfYearsToTrain) {
        this.numberOfYearsToTrain = numberOfYearsToTrain;
    }

    public String getTraineeInfo() {
        return "numberOfYearsToTrain";
    }
}
