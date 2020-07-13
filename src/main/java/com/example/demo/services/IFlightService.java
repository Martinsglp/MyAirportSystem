package com.example.demo.services;

import java.util.Date;

public interface IFlightService {

    boolean registerFlight(Date creationDateTime, int duration, String airportFrom, String airportTo);
}
