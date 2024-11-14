package com.flowable.gsd.work.Delegates;

import org.flowable.common.engine.api.variable.VariableContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flowable.gsd.work.services.CreditCardService;
import com.flowable.platform.tasks.AbstractPlatformTask;
import com.flowable.platform.tasks.ExtensionElementsContainer;

@Component("creditCardValidation")
public class CreditCardValidationTask extends AbstractPlatformTask {
    
    @Autowired
    CreditCardService creditCardService;

    @Override
    public void executeTask(VariableContainer variableContainer,
            ExtensionElementsContainer extensionElementsContainer) {
        // TODO Auto-generated method stub
        String cardNumber = (String)variableContainer.getVariable("cardNumber");
        boolean isValid = creditCardService.verifyCreditCard(cardNumber).isValid();

        variableContainer.setVariable("cardValid", isValid);

    }
}
