package com.example.java.validation;

import com.example.java.validation.entities.Person;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends AbstractValidatorTest {

    @Test
    void testExcetion() {


        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validateWithException(person);
        });
    }

}
