package com.flowable.gsd.work.services;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowable.gsd.work.models.BookFlightCommand;

@Service("flightBookingService")
public class FlightBookingService {

    @Autowired
    RuntimeService runtimeService;

    public boolean bookFlight(BookFlightCommand bookFlightCommand) 
    {
        ProcessInstance instance = runtimeService
        .createProcessInstanceBuilder()
        .processDefinitionKey("flightBooking")
        .variable("departureInfoAirportCode", bookFlightCommand.departureInfo().AirportCode())
        .variable("flightClass", bookFlightCommand.departureInfo().flightClass())
        .start();

        return instance != null;
    }
}
