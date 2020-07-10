package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.models.enums.userType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	
	/*@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_ID;*/

	@Column(name = "Type")
	private userType type;

	public RegisteredUser(
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String username,
			@Size(min = 6, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String password,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String name,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String surname,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String email,
			@Size(min = 0, max = 100) int extra_points, userType type) {
		super(username, password, name, surname, email);
		Extra_points = extra_points;
		this.type = type;
	}
	
	
	
	
	
	
}
