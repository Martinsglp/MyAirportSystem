package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.enums.userType;

public interface IRegisterService {
	boolean registerRegUser(String username, String password, String name, String surname, String email, userType type);
	
	BoardingPass selectOneBoardingPassById(int id)throws Exception ;
	
	ArrayList<BoardingPass> getAllFlightsByBoardingPass(BoardingPass pass)throws Exception;
	
	


}
