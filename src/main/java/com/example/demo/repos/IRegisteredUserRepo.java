package com.example.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.RegisteredUser;

public interface IRegisteredUserRepo extends CrudRepository<RegisteredUser, Integer>{
	
	boolean existsByNameAndSurnameAndPassword(String name, String surname, String password);
	
	boolean existsByUsernameAndPassword(String username, String password);
	
	
	
}
