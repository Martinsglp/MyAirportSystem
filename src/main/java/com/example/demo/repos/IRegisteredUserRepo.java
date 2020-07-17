package com.example.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.enums.userType;

public interface IRegisteredUserRepo extends CrudRepository<RegisteredUser, Integer>{
	
	boolean existsByNameAndSurnameAndPassword(String name, String surname, String password);
	
	boolean existsByUsernameAndPassword(String username, String password);
	
	RegisteredUser findByUsername(String username);

	ArrayList<RegisteredUser> findByVIP(boolean b);

	ArrayList<RegisteredUser> findByType(userType vip);

	boolean existsByUsername(String username);
	
	//ArrayList<BoardingPass> findBoardingPassById(int id);
	
}
