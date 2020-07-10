package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SeatTable")
@Getter @Setter @ToString @NoArgsConstructor
public class Seat {
	
	private char row;
	private short seat;
	
	
	public Seat(char row, short seat) {
		super();
		this.row = row;
		this.seat = seat;
	}
	
	
	
	
}
