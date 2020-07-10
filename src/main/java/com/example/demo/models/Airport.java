package com.example.demo.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "AirportTable")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Airport {

    @Id
    @Column(name = "AI_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ai_ID;

    @Column(name="AirportName")
    @Pattern(regexp = "[a-zA-Z\\d\\s]+$", message = "Incorrect input")
    private String airportName;

    @Column(name="Capacity")
    @Min(value = 0L, message = "The value must be positive")
    private int capacity;

    public Airport(String airportName, int capacity) {
        this.airportName = airportName;
        this.capacity = capacity;
    }
}
