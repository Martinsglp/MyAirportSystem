package com.example.demo.forms;

import com.example.demo.models.enums.AirportList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class BookAFlightForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;

    private AirportList airportFrom;

    private AirportList airportTo;
}
