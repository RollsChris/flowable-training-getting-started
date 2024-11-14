package com.flowable.gsd.work.services;

import org.apache.commons.validator.CreditCardValidator;
import org.springframework.stereotype.Service;

@Service("creditCardService")
public class CreditCardService {
    public VerificationResult verifyCreditCard(String creditCardNumber) {
        CreditCardValidator validator = new CreditCardValidator();
        boolean isValid = validator.isValid(creditCardNumber);

        return new VerificationResult(creditCardNumber, isValid, isValid ? "Credit card is valid" : "Credit card is invalid");
    }

    public boolean isValid(String creditCardNumber){
        CreditCardValidator validator = new CreditCardValidator();
        return validator.isValid(creditCardNumber);
    }
    
}
