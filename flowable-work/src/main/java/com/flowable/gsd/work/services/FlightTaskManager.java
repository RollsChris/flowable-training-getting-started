package com.flowable.gsd.work.services;

import java.util.List;

import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowable.core.common.api.security.SecurityScope;
import com.flowable.core.spring.security.SecurityUtils;
import com.flowable.gsd.work.models.FlightTaskInformation;

@Service
public class FlightTaskManager {

    @Autowired
    TaskService taskService;

    public List<FlightTaskInformation> getAllOpen(){

        SecurityScope scope = SecurityUtils.getCurrentUserSecurityScope();
        
        String userid = scope.getUserId();


        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userid).list();
        List<FlightTaskInformation> flightTaskInformations = tasks.stream().map(x -> new FlightTaskInformation(x.getId(), x.getName(), x.getDescription(), x.getDueDate())).toList();


        return flightTaskInformations;

    }
}
