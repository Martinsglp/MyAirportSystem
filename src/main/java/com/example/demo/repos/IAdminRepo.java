package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Admin;

import com.example.demo.models.RegisteredUser;

public interface IAdminRepo extends CrudRepository<Admin, Integer> {
	boolean existsByNameAndSurname(String name, String surname);

	boolean existsByPassword(String password);
	
	boolean existsByNameAndSurnameAndPassword(String name,String surname, String password);

	boolean existsByUsernameAndPassword(String username, String password);
	
	RegisteredUser findByNameAndSurname(String name, String surname);


}
