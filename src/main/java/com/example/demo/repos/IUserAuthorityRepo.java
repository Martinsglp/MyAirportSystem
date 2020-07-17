package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.UserAuthority;

public interface IUserAuthorityRepo extends CrudRepository<UserAuthority, Integer> {

	UserAuthority findByRoleTitle(String string);
	
	
	
	
	
}
