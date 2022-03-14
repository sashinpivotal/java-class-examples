package com.example.junitexercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calculator1Test {

    private Calculator1 calculator1;

    @BeforeEach
    void setUp() {
        calculator1 = new Calculator1();
    }

    @Test
    void should_return_added_value_when_two_numbers_are_given() {

        assertEquals(5, calculator1.add(2, 3));
        Assertions.assertThat(calculator1.add(2, 3)).isEqualTo(5);
    }

    @Test
    void should_return_subtracted_value_when_two_numbers_are_given() {

        assertEquals(-1, calculator1.subtract(2,3));
        Assertions.assertThat(calculator1.subtract(2, 3)).isEqualTo(-1);
    }
}