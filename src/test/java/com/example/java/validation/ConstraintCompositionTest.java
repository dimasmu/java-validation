package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest {

    @Test
    void testComposition() {

        Payment payment = new Payment();
        payment.setOrderId("12345uhdhsfh9asdasdasdas");
        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }

}
