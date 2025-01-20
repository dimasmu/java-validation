package com.example.java.validation;

import com.example.java.validation.entities.Address;
import com.example.java.validation.entities.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNested() {

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        Address address = new Address();
        person.setAddress(address);

//        validator.validate(person).var;
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> violation : violations) {

            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println("=================================================");
        }
    }

}
