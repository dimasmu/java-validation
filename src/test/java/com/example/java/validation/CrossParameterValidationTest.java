package com.example.java.validation;

import com.example.java.validation.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest {

    @Test
    void testCrossParameterValidation() throws NoSuchMethodException {

        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);

        String username = "Bayu";
        String password = "rahasia";
        String retypePassword = "rahasia";

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{
                username, password, retypePassword
        });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
        }
    }

}
