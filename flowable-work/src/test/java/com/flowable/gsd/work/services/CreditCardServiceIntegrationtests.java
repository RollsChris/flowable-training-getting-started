package com.flowable.gsd.work.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreditCardServiceIntegrationtests {
    
    @Autowired
    CreditCardService creditCardService;

    @Test
    void passingTestValidateCreditCard() {
        VerificationResult result = creditCardService.verifyCreditCard("4111 1111 1111 1111");
        assertTrue(result.isValid());
    }
    @Test
    void failTestValidateCreditCard() {
        VerificationResult result = creditCardService.verifyCreditCard("@@@@@@@@@@@@@@@@");
        assertFalse(result.isValid());
    }
}
