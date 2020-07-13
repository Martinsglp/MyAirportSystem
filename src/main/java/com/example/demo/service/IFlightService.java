package com.example.demo.services;

import java.time.LocalDateTime;

public interface IFlightService {

    boolean registerFlight(LocalDateTime creationDateTime, int duration, String airportFrom, String airportTo);
}
