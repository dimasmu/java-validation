package com.example.java.validation;

import com.example.java.validation.entities.Address;
import com.example.java.validation.entities.Person;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructionValidationTest extends AbstractValidatorTest {

    @Test
    void testValidateConstructorParameter() throws NoSuchMethodException {

        String firstName = "";
        String lastName = "";
        Address address = null;

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println("==========================================");
        }

    }

}
