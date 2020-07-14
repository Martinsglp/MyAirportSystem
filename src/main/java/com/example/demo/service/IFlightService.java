package com.example.demo.service;

import com.example.demo.models.Flight;
import com.example.demo.models.enums.AirportList;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFlightService {

    boolean registerFlight(LocalDateTime creationDateTime, int duration, AirportList airportFrom, AirportList airportTo);

    ArrayList<Flight> showSelectedFlightsInfoByAirports(AirportList airportFrom, AirportList airportTo);

    void saveTestingData();


    boolean checkIfFlightIsInDB(Flight flight);


}

