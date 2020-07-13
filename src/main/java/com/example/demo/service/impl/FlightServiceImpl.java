/*<<<<<<< HEAD:src/main/java/com/example/demo/service/FlightServiceImpl.java
package com.example.demo.service;
======= */
package com.example.demo.service.impl;
//>>>>>>> master:src/main/java/com/example/demo/service/impl/FlightServiceImpl.java

import com.example.demo.models.Flight;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.service.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FlightServiceImpl implements IFlightService{

    @Autowired
    IFlightRepo flightRepo;

    @Override
    public boolean registerFlight(LocalDateTime dateAndTime, int duration, String airportFrom, String airportTo) {
        if (flightRepo.existsByCreationDateTimeAndDurationAndAirportFromAndAirportTo(dateAndTime, duration, airportFrom, airportTo)) {
            return false;
        }
        flightRepo.save(new Flight(dateAndTime, duration, airportFrom, airportTo));
        return true;
    }



}