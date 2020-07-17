package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.models.RegisteredUser;

public class RegisteredUserDetails implements UserDetails {
	private RegisteredUser regUser;
	

	public RegisteredUserDetails(RegisteredUser regUser) {
		super();
		this.regUser = regUser;
	}

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleAuthorityObject = new SimpleGrantedAuthority(regUser.getUserAutority().getRoleTitle());
		return Arrays.asList(simpleAuthorityObject);
	}

	@Override
	public String getPassword() {
		return regUser.getPassword();
	}

	@Override
	public String getUsername() {
		return regUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
