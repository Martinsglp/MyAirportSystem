package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Entity
@Table(name = "BoardingPassTable")
@Getter @Setter @ToString @NoArgsConstructor
public class BoardingPass {


	private int bp_ID;
	
	private boolean Priority_Group;
	
	private Seat seat;
	
	private User Passenger_ID;
	
	private int flight_ID;

	public BoardingPass(boolean priority_Group, Seat seat, User passenger_ID, int flight_ID) {
		super();
		Priority_Group = priority_Group;
		this.seat = seat;
		Passenger_ID = passenger_ID;
		this.flight_ID = flight_ID;
	}
	
	
	
}
