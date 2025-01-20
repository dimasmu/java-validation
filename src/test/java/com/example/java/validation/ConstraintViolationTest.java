package com.example.java.validation;

import com.example.java.validation.entities.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationFailed() {

        Person person = new Person();
        person.setFirstName("John asdwqwerty 1234567 zxcvbnm");
        person.setLastName("Dalton asdwqwerty 1234567 zxcvbnm");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getRootBean());
            System.out.println("Property: " + violation.getPropertyPath().toString());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("path: " + violation.getPropertyPath());
        }

    }

    @Test
    void testValidationSuccess() {

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Dalton");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getRootBean());
            System.out.println("Property: " + violation.getPropertyPath().toString());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("path: " + violation.getPropertyPath());
        }

    }

}
