package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SeatTable")
@Getter @Setter @ToString @NoArgsConstructor
public class Seat {
	
	@Id
	@Column(name = "SE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int se_ID;
	
	@Column(name = "planeRow")
	private char planeRow;
	
	@Column(name = "SeatNr")
	private short seatNr;

	public Seat(char planeRow, short seatNr) {
		super();
		this.planeRow = planeRow;
		this.seatNr = seatNr;
	}

	
	
	
	
	
	
	
	
}
