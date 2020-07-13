package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.User;

public interface IAdminService {

	boolean authorise(User user);
	
	ArrayList<RegisteredUser> selectAllUsers();
	ArrayList<Flight> selectAllFlights();
}
