package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Entity
@Table(name = "RegisteredUserTable")
@Getter @Setter @NoArgsConstructor @ToString
public class RegisteredUser extends User{

	@Id
	@Column(name = "RUS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rus_ID;
	
	@Column(name = "Extra_Points")
	@Size(min = 0, max = 100)
	private int Extra_points;
	
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_ID;

	public RegisteredUser(
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String username,
			@Size(min = 6, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String password,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String name,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String surname,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String email,
			@Size(min = 0, max = 100) int extra_points, int role_ID) {
		super(username, password, name, surname, email);
		Extra_points = extra_points;
		this.role_ID = role_ID;
	}
/*
	@OneToMany(mappedBy="RegisteredUser")
	private Collection<BoardingPass> boardingPasses;
	*/
	
}
