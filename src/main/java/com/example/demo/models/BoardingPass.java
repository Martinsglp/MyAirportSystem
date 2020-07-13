package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

import java.util.Collection;

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
	
	
	
}
