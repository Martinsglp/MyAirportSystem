package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	
	private int role_ID;
	
	
	
	
}
