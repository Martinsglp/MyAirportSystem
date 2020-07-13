package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "FlightTable")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Flight {

    @Id
    @Column(name = "FL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fl_ID;

    @Column(name="DateAndTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;

    @Column(name="Duration")
    @Min(value = 0L, message = "The value must be positive")
    private int duration;

    @Column(name="AirportFrom")
    @Pattern(regexp = "[a-zA-Z\\d\\s]+$", message = "Incorrect input")
    private String airportFrom;

    @Column(name="AirportTo")
    @Pattern(regexp = "[a-zA-Z\\d\\s]+$", message = "Incorrect input")
    private String airportTo;

    public Flight(LocalDateTime dateAndTime, int duration, String airportFrom, String airportTo) {
        this.creationDateTime = dateAndTime;
        this.duration = duration;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
    }

    @OneToMany(mappedBy = "flight")
    private Collection<BoardingPass> boardingPasses;

}
