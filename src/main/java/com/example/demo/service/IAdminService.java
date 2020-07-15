package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.models.Admin;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.VIPUser;
import com.example.demo.models.enums.userType;

public interface IAdminService {

	boolean registerAdmin(String username, String password, String name, String surname, String email, userType type);
	
	boolean authorise(Admin admin);
	
	ArrayList<RegisteredUser> selectAllRegisteredUsers();
	
	ArrayList<Flight> selectAllFlights();
	
	ArrayList<BoardingPass> selectAllBoardingPasses();
	
	ArrayList<VIPUser> selectAllVIPUsers();
	
	boolean deleteFlightById(int id);
	
	//boolean updateFlightById(int id, Date date, int duration,);
	//TODO write update shit...
}
