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
@Table(name = "VIPTable")
@Getter @Setter @ToString @NoArgsConstructor
public class VIPUser extends User{
	
	@Id
	@Column(name = "VIP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vip_ID;
	
	@Column(name="VIP_Priority")
	private boolean vip_priority;
	
	
	@Column(name = "Type")
	private userType type;

	public VIPUser(boolean vip_priority, userType type) {
		this.vip_priority = vip_priority;
		this.type = type;
	}

	public VIPUser(@Size(min = 4, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String username,
				   @Size(min = 3, max = 30) String password,
				   @Size(min = 3, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String name,
				   @Size(min = 3, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Check name!") String surname,
				   @Size(min = 4, max = 30) @Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$", message = "Check name!") String email,
				   boolean vip_priority, userType type) {
		super(username, password, name, surname, email);
		this.vip_priority = vip_priority;
		this.type = type;
	}
}
