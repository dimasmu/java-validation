package com.example.java.validation;

import com.example.java.validation.entities.Address;
import com.example.java.validation.entities.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData() {

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress(new Address());
        person.getAddress().setCity("San Francisco");
        person.getAddress().setCountry("USA");
        person.getAddress().setStreet("PENJOMPONGAN");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add(" ");
        person.getHobbies().add("Gaming");

        validate(person);

    }

}
