package com.example.demo.repos;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.enums.AirportList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFlightRepo extends CrudRepository<Flight, Integer> {

    boolean existsByCreationDateTimeAndDurationAndAirportFromAndAirportTo(LocalDateTime dateAndTime, int duration, AirportList airportFrom, AirportList airportTo);

    boolean existsByAirportFromAndAirportTo(AirportList airportFrom, AirportList airportTo);
    // exists returns boolean, findBy returns object
    ArrayList<Flight> findByAirportFromAndAirportTo(AirportList airportFrom, AirportList airportTo);

    ArrayList<BoardingPass> findByBoardingPasses(BoardingPass pass);
}
