package com.flowable.gsd.work.bpmn;

import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Autowired
    TaskService taskService;

    @Test 
    @Deployment(resources = { "test-processes/testProcess.bpmn" })
    public void CredCardValidationTest(){

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("testProcess", Map.of("cardNumber", false));

        assertTrue(processInstance.getProcessVariables().containsKey("cardNumber"));

        assertEquals(1, taskService.createTaskQuery().count());
        // Task firstTask = taskService.createTaskQuery().singleResult();
        // taskService.complete(firstTask.getId());

        // assertEquals(1, taskService.createTaskQuery().count());
        // taskService.complete(taskService.createTaskQuery().singleResult().getId());

        // assertEquals(0, taskService.createTaskQuery().count());


        // // Second process with skipUserTask2 = true
        // variables = Map.of("skipUserTask2", true);

        // processInstance = runtimeService.startProcessInstanceByKey("twoUserTasks", variables);
        // assertTrue(processInstance.getProcessVariables().containsKey("skipUserTask2"));

        // assertEquals(1, taskService.createTaskQuery().count());
        // firstTask = taskService.createTaskQuery().singleResult();
        // taskService.complete(firstTask.getId());

        // assertEquals(0, taskService.createTaskQuery().count());

        // // Third process with skipUserTask2 missing, should result in a crash
        // runtimeService.startProcessInstanceByKey("twoUserTasks");
        // assertEquals(1, taskService.createTaskQuery().count());
        // firstTask = taskService.createTaskQuery().singleResult();
        // Task finalFirstTask = firstTask;
        // assertThrows(Exception.class, () -> taskService.complete(finalFirstTask.getId()));
    }
}



