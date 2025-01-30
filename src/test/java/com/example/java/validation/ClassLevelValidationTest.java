package com.example.java.validation;

import com.example.java.validation.entities.Register;
import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest {

    @Test
    void testClassLevel() {

        Register register = new Register();
        register.setUsername("Bondan");
        register.setPassword("Pradana");
        register.setRetypePassword("huehue");

        validate(register);

    }

}
