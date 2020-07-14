package com.example.demo.models;

import com.example.demo.models.enums.AirportList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "FlightTable")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Flight implements Comparable<Flight>{

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
    private AirportList airportFrom;

    @Column(name="AirportTo")
    private AirportList airportTo;
  
    @Column(name = "Price")
    @Min(value = 0, message = "The value must be positive")
    private double flightPrice;

    public Flight(LocalDateTime dateAndTime, int duration, AirportList airportFrom, AirportList airportTo, double flightPrice) {
        this.creationDateTime = dateAndTime.withNano(0);
        this.duration = duration;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightPrice = flightPrice;
    }

    @OneToMany(mappedBy = "flight")
    
    @Column(name = "Price")
    @Min(value = 0, message = "The value must be positive")
    private double flightPrice;
 
    public Flight(LocalDateTime creationDateTime, @Min(value = 0, message = "The value must be positive") int duration,
			AirportList airportFrom, AirportList airportTo,
			@Min(value = 0, message = "The value must be positive") double flightPrice) {
		super();
		this.creationDateTime = creationDateTime;
		this.duration = duration;
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.flightPrice = flightPrice;
	}

	@OneToMany(mappedBy = "flight")

    private Collection<BoardingPass> boardingPasses;

    @Override
    public int compareTo(Flight o) {
        return 0;
    }
}
