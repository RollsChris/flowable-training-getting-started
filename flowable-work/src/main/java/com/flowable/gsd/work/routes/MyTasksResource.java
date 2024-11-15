package com.flowable.gsd.work.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.gsd.work.models.FlightTaskInformation;
import com.flowable.gsd.work.services.FlightTaskManager;

@RestController
public class MyTasksResource {

    @Autowired
    FlightTaskManager flightTaskManager;

    @GetMapping("/airline-api/my-tasks")
    public List<FlightTaskInformation> my_tasks() {
        return flightTaskManager.getAllOpen();
    }
}
