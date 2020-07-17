package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.enums.AirportList;
import com.example.demo.models.enums.userType;

public interface IRegisterService {
	boolean registerRegUser(String username, String password, String name, String surname, String email, userType type);
	
	BoardingPass selectOneBoardingPassById(int id)throws Exception ;
	
	ArrayList<BoardingPass> getAllFlightsByBoardingPass(BoardingPass pass)throws Exception;
	
	boolean checkIfUserIsViP(Collection<RegisteredUser> registeredUsers);
	
	//boolean checkIn(BoardingPass boardingPass);

	boolean checkIfOneUserIsViP(RegisteredUser registeredUser);

    boolean bookAFlight(int userID, LocalDateTime dateTime, AirportList nameFrom, AirportList nameTo);

	ArrayList<Flight> getAllFlightsByAirports(AirportList from, AirportList to);

	boolean earnExtraPoints(BoardingPass bp, RegisteredUser ru);
}
