package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest {

    @Test
    void testGroupSequence() {

        Payment payment = new Payment();
        payment.setOrderId("00001");

        validateWithGroup(payment, PaymentGroup.class);

    }


}
