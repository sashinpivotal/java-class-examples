package com.example.junitexercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {

    private MyArray myArray;

    @BeforeEach
    void setUp() {
        myArray = new MyArray();
    }

    @DisplayName("negative testing using JUnit 5 assert")
    @Test
    void getMeAString_throws_IndexOutOfBoundsException_given_invalid_index1() {

        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    myArray.getMeAString(10);
                });
    }

    @DisplayName("negative testing using AssertJ")
    @Test
    void getMeAString_throws_IndexOutOfBoundsException_given_invalid_index2() {

        org.assertj.core.api.Assertions.assertThatThrownBy(
                        () -> {
                            myArray.getMeAString(10);
                        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 10 out of bounds for length 3");
    }
}