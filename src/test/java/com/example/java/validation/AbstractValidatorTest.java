package com.example.java.validation;

import com.example.java.validation.extractor.DataIntegerValueExtractor;
import com.example.java.validation.extractor.DataValueExtractor;
import com.example.java.validation.extractor.EntryValueExtractorKey;
import com.example.java.validation.extractor.EntryValueExtractorValue;
import com.example.java.validation.payload.EmailErrorPayload;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {

//        validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();

    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println("===============================================");
        }
    }

    void validateWithException(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    void validateWithGroup(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println("===============================================");
        }
    }

    void validateWithPayload(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());

//            violation.getConstraintDescriptor().getPayload().var;

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if (payloadClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println(violation.getPropertyPath().toString());
            System.out.println("===============================================");
        }
    }

}
