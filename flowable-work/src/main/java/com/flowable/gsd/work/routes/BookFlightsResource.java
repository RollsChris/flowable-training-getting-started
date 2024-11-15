package com.flowable.gsd.work.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.gsd.work.models.BookFlightCommand;
import com.flowable.gsd.work.services.FlightBookingService;

@RestController
public class BookFlightsResource {
    
    @Autowired
    FlightBookingService bookingService;


    @PostMapping("/airline-api/book-flight")
    public boolean book_flight(@RequestBody BookFlightCommand bookFlightCommand ) {
        return bookingService.bookFlight(bookFlightCommand);
    }
}


