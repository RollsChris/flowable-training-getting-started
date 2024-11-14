package com.flowable.gsd.work.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.gsd.work.services.CreditCardService;
import com.flowable.gsd.work.services.VerificationResult;

@RestController
public class CreditCardResource {
    
    @Autowired
    CreditCardService creditCardService;


    @GetMapping("/verify/{creditCardNumber}")
    public VerificationResult verifyCreditCard(@PathVariable String creditCardNumber) {
        return creditCardService.verifyCreditCard(creditCardNumber);
    }
}
