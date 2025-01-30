package com.example.java.validation;

import com.example.java.validation.entities.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidatorTest {

    @Test
    void testConstraintDescriptor() {

        Person person = new Person();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {

            ConstraintDescriptor<?> constraintDescriptor = violation.getConstraintDescriptor();
            System.out.println(constraintDescriptor.getAnnotation());
            System.out.println(constraintDescriptor.getPayload());
            System.out.println(constraintDescriptor.getAttributes());
            System.out.println(constraintDescriptor.getClass());
            System.out.println(constraintDescriptor.getGroups());
            System.out.println(constraintDescriptor.getComposingConstraints());
            System.out.println(constraintDescriptor.getMessageTemplate());
            System.out.println("===============================================================");
        }

    }

}
