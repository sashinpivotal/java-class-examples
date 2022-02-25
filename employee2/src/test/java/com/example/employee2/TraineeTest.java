package com.example.employee2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {

    @Test
    void calculateSalary_should_return_valid_value_given_valid_basicSalary() {

        Trainee trainee = new Trainee(29864, "Jack",
                "Mumbai India", 442085L,
                45000);
        double salary = trainee.calculateSalary();
        Assertions.assertThat(salary).isEqualTo(608085.0);
    }
}