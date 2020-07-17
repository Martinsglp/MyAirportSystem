package com.example.demo.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "AuthorityTable")
@Getter @Setter @NoArgsConstructor @ToString
public class UserAuthority {
	
	@Id
	@Column(name = "AU_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int au_ID;
	
	
	@Column(name = "Role_Title")
	private String roleTitle;


	public UserAuthority(String roleTitle) {
		super();
		this.registeredUsers = new ArrayList<RegisteredUser>();
		this.roleTitle = roleTitle;
	}

	public void addNewRegisteredUser(RegisteredUser registeredUser){
		registeredUsers.add(registeredUser);
		
	}

	@ToString.Exclude
	@OneToMany(mappedBy = "userAutority")
	private Collection<RegisteredUser> registeredUsers;
	
	
	
}
