/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.junitexercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Calculator2Tests {

    private Calculator2 calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator2();
    }

    @Test
    @DisplayName("Using JUnit 5 assertion")
    void add_returns_added_value_given_two_numbers1() {
        assertEquals(2, calculator.add(1, 1),
                "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("Using AssertJ assertion")
    void add_returns_added_value_given_two_numbers2() {
        Assertions.assertThat(calculator.add(1, 1))
                .withFailMessage("1 + 1 should equal 2")
                .isEqualTo(2);
    }

    @DisplayName("parameterized test using JUnit 5 assert")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add_returns_added_value_given_multiple_test_numbers1
            (int first, int second, int expectedResult) {
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("parameterized test using AssertJ")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add_returns_added_value_given_multiple_test_numbers2
            (int first, int second, int expectedResult) {
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
        Assertions.assertThat(calculator.add(first, second))
                .withFailMessage("%d + %d should equal %d", first, second, expectedResult)
                .isEqualTo(expectedResult);
    }

}
