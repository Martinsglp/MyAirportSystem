package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.User;
import com.example.demo.models.VIPUser;

public interface IAdminService {

	boolean register(String name, String surname);
	
	boolean authorise(User user);
	
	ArrayList<RegisteredUser> selectAllUsers();
	
	ArrayList<Flight> selectAllFlights();
	
	ArrayList<BoardingPass> selectAllBoardingPasses();
	
	ArrayList<VIPUser> selectAllVIPUsers();
	
	
}
