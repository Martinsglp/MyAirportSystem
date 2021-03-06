package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

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
	
	@Column(name = "Priority")
	private boolean Priority_Group;

	public BoardingPass(boolean priority_Group, RegisteredUser registeredUser, Flight flight, Seat seat) {
		Priority_Group = priority_Group;
		this.registeredUser = registeredUser;
		this.flight = flight;
		this.seat = seat;
	}

	@ManyToOne
	@JoinColumn(name="RUS_ID")
	private RegisteredUser registeredUser;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "FL_ID")
	private Flight flight;

	@OneToOne
	@JoinColumn(name="SE_ID")
	private Seat seat;
	
	
	

}
