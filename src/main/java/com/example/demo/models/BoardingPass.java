package com.example.demo.models;

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
	
	
	public BoardingPass(boolean priority_Group) {
		super();
		Priority_Group = priority_Group;
		
	}

	@ManyToOne
	@JoinColumn(name="RUS_ID")
	private RegisteredUser registeredUser;

	@ManyToOne
	@JoinColumn(name = "FL_ID")
	private Flight flight;

	
}
