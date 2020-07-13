package com.example.demo.repos;

import com.example.demo.models.Flight;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface IFlightRepo extends CrudRepository<Flight, Integer> {

    boolean existsByCreationDateTimeAndDurationAndAirportFromAndAirportTo(LocalDateTime dateAndTime, int duration,
                                                                          String airportFrom, String airportTo);


}
