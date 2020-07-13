package com.example.demo.repos;

import com.example.demo.models.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface IFlightRepo extends CrudRepository<Flight, Integer> {

    boolean existsByCreationDateTimeAndDurationAndAirportFromAndAirportTo(Date dateAndTime, int duration,
                                                                     String airportFrom, String airportTo);


}
