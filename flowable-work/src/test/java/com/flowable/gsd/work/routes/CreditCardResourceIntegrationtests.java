package com.flowable.gsd.work.routes;

import org.flowable.spring.impl.test.FlowableSpringExtension;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flowable.gsd.work.services.VerificationResult;

@SpringBootTest
@ExtendWith(FlowableSpringExtension.class)
public class CreditCardResourceIntegrationtests {
    @Autowired
    CreditCardResource creditCardResource;

    @Test
    void call_verifyCreditCard_pass() {
        VerificationResult result = this.creditCardResource.verifyCreditCard("4111111111111111");

        assertTrue(result.isValid());
    }

    @Test
    void call_verifyCreditCard_false() {
        VerificationResult result = this.creditCardResource.verifyCreditCard("111111111111111");

        assertFalse(result.isValid());
    }
}
