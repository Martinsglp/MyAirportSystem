package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.demo.models.Admin;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.enums.AirportList;
import com.example.demo.models.enums.userType;

public interface IAdminService {

	boolean registerAdmin(String username, String password, String name, String surname, String email, userType type);
	
	boolean authorise(Admin admin);
	
	ArrayList<RegisteredUser> selectAllRegisteredUsers();
	
	ArrayList<RegisteredUser> selectAllVipRegisteredUsers();
	
	ArrayList<Flight> selectAllFlights();
	
	ArrayList<BoardingPass> selectAllBoardingPasses();
	
	boolean deleteFlightById(int id);
	
	//INSERT
	
	
	//boolean updateFlightById(int id, Date date, int duration,);
	//TODO write update shit...

	boolean findFlightByDateAndAirports(LocalDateTime dateTime, AirportList nameFrom, AirportList nameTo);

	boolean bookAFlight(int userID, LocalDateTime dateTime, AirportList nameFrom, AirportList nameTo);

}
