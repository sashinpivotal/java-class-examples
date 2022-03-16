package com.example.junitexercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Calculator1Test1 {

    @Test
    void add_should_return_valid_added_value_given_two_numbers() {

        Calculator1 calculator1 = new Calculator1();
        int actualResult = calculator1.add(4, 5);

        Assertions.assertThat(actualResult).isEqualTo(9);
    }
}
