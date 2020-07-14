package com.example.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass 
@Getter @Setter @ToString @NoArgsConstructor
public class User {
	
	@Column(name="Username")
	@Size(min=4, max=30)
	@Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!")
	private String username;
	
	@Column(name="Password")
	@Size(min=6, max=30)
	@Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!")
	private String password;
	
	@Column(name="Name")
	@Size(min=4, max=30)
	@Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!")
	private String name;
	
	@Column(name="SurName")
	@Size(min=4, max=30)
	@Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!")
	private String surname;
	
	@Column(name="Email")
	@Size(min=4, max=30)
	//@Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!")
	@Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$", message = "Check name!")
	private String email;

	public User(@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String username,
			@Size(min = 6, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String password,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String name,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String surname,
			@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	
	
	
	
}
