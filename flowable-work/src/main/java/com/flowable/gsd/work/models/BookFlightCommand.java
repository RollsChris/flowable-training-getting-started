package com.flowable.gsd.work.models;

public record BookFlightCommand(DepartureInfo departureInfo, PassengerInformation passengerInformation, ReturnInfo returnInfo) {

}
