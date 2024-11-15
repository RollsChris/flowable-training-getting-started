package com.flowable.gsd.work.bpmn;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(FlowableSpringExtension.class) 
@ExtendWith(SpringExtension.class)
public class creditCardValidationTests {

    @Autowired
    RuntimeService runtimeService;

    @Test 
    @Deployment(resources = { "test-processes/testProcess.bpmn" })
    public void CredCardValidationTest(){
        System.out.println("Successful");
    }
}



