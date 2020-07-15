package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.VIPUser;
import com.example.demo.models.enums.userType;

public interface IVIPUserRepo extends CrudRepository<VIPUser, Integer>{
	
	boolean existsByNameAndSurname(String name, String surname);
	
	boolean existsByUsername(String username);
	
	
}
