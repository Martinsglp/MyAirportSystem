package com.example.demo.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.example.demo.models.enums.AirportList;

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
    private AirportList name;

    @Column(name="Capacity")
    @Min(value = 0L, message = "The value must be positive")
    private int capacity;

	public Airport(@Pattern(regexp = "[a-zA-Z\\d\\s]+$", message = "Incorrect input") AirportList name,
			@Min(value = 0, message = "The value must be positive") int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
    
}
