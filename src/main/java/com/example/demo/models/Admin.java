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
@Table(name = "Admin")
@Getter @Setter @ToString @NoArgsConstructor
public class Admin extends User{

	@Id
	@Column(name = "AD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ad_ID;
	
	
	private int role_ID;
	
}
