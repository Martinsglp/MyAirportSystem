package com.example.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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
	@Min(0)
	@Max(100)
	private int Extra_points;
	
	@Column(name="IsVIP")
	private boolean VIP;
	
	@ManyToOne
	@JoinColumn(name = "AU_ID")
	private UserAuthority userAutority;
	
	public RegisteredUser(@Size(min = 0, max = 100) int extra_points, UserAuthority type) {
		Extra_points = extra_points;
		this.userAutority = type;
	}
	
	public RegisteredUser(
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String username,
			@Size(min = 3, max = 30) String password,
			@Size(min = 3, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String name,
			@Size(min = 3, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String surname,
			@Size(min = 4, max = 30) @Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$", message = "Check name!") String email,
			@Min(0) @Max(100) int extra_points, boolean isVIP, UserAuthority type) {
		super(username, password, name, surname, email);
		Extra_points = extra_points;
		this.VIP = isVIP;
		this.userAutority = type;
	}
	
	

	@ToString.Exclude
	@OneToMany(mappedBy = "registeredUser")
	private Collection<BoardingPass> boardingPasses;
	
	
	
	
}
