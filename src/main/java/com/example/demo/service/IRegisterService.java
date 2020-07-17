package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.UserAuthority;


public interface IRegisterService {
	boolean registerRegUser(String username, String password, String name, String surname, String email, UserAuthority type);
	
	BoardingPass selectOneBoardingPassById(int id)throws Exception ;
	
	ArrayList<BoardingPass> getAllFlightsByBoardingPass(BoardingPass pass)throws Exception;
	
	boolean checkIfUserIsViP(Collection<RegisteredUser> registeredUsers);
	
	ArrayList<RegisteredUser> selectAllRegisteredUsers();
	
	ArrayList<Flight> selectAllFlights();
	

}
