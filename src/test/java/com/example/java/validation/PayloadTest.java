package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class PayloadTest extends AbstractValidatorTest {

    @Test
    void testPayload() {

        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("311111");

        validateWithPayload(payment, CreditCardPaymentGroup.class);

    }

}
