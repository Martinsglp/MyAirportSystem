package com.example.demo.service;

import java.time.LocalDateTime;

public interface IFlightService {

    boolean registerFlight(LocalDateTime creationDateTime, int duration, String airportFrom, String airportTo);
}

////