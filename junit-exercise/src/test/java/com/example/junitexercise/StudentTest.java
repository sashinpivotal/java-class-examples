package com.example.junitexercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("jon", 20);
    }

    @Test
    void getStudentInfo_should_return_name_and_age() {

        String studentInfo = student.getStudentInfo();
        String expectedStudentInfo = "jon is 20 years old";

        assertThat(studentInfo)
                .isEqualTo(expectedStudentInfo);
    }

    @Test
    void retrieveStudentNameInUpperCase_should_return_student_name_in_upper_case() {

        String actual = student.retrieveStdudentNameInUpperCase();
        String expected = "JON";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void updateName_should_throw_NameSizeIncorrectException_when_size_of_name_is_less_than_5() {

        org.junit.jupiter.api.Assertions.assertThrows(NameSizeIncorrectException.class,
                () -> {
                    student.updateName("xyz");
                });

    }
}
