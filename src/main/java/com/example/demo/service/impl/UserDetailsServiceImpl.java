package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.models.RegisteredUser;
import com.example.demo.repos.IRegisteredUserRepo;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IRegisteredUserRepo regUserRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		RegisteredUser reg1 = regUserRepo.findByUsername(username);
		
		if(reg1 == null)
			throw new UsernameNotFoundException("User not found in data base");
		else

		return new RegisteredUserDetails(reg1);
	}
	
	
	
}
