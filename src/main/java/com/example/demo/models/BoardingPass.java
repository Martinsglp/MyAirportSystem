package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Entity
@Table(name = "BoardingPassTable")
@Getter @Setter @ToString @NoArgsConstructor
public class BoardingPass {

	@Id
	@Column(name = "BP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bp_ID;
	
	private boolean Priority_Group;
	
	@Min(1)
	@Max(800)
	@Column(name = "Seats")
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
