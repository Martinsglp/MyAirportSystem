package com.example.demo.service;

import com.example.demo.models.Flight;
import com.example.demo.models.enums.AirportList;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFlightService {

    boolean registerFlight(LocalDateTime creationDateTime, int duration, AirportList airportFrom, AirportList airportTo, double price);

    ArrayList<Flight> showSelectedFlightsInfoByAirports(AirportList airportFrom, AirportList airportTo);

    void saveTestingData();

	boolean updateFlightById(int id, AirportList airportFrom, AirportList airportTo, Flight flight);

	boolean deleteFlightById(int id);

	boolean updateFlightObjectById(int id, Flight flight);


}

