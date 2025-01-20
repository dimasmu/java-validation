package com.example.java.validation;

import com.example.java.validation.entities.Person;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest {

    @Test
    void testSayHello() throws NoSuchMethodException {

        Person person = new Person();

        String name = "Budi";

        Method method = Person.class.getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println("==========================================");
        }

    }

    @Test
    void testFullName() throws NoSuchMethodException {

        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");

        String fullName = person.fullName();

//        executableValidator.validateReturnValue(person, method, fullName);
        Method method = Person.class.getMethod("fullName");

        Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, method, fullName);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println("==========================================");
        }
    }

}
