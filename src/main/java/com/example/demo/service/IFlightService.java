package com.example.demo.service;

import com.example.demo.models.Flight;
import com.example.demo.models.enums.AirportList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IFlightService {

    boolean registerFlight(LocalDateTime creationDateTime, int duration, AirportList airportFrom, AirportList airportTo, double flightPrice);

    List<Flight> showSelectedFlightsInfoByAirports(AirportList airportFrom, AirportList airportTo);

    void saveTestingData();

    boolean checkIfFlightIsInDB(Flight flight);

    ArrayList<Flight> selectAllFlights();
}

