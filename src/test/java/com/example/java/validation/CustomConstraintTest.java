package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidatorTest {

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("s");

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }

}
