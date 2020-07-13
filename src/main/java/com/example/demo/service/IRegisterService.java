package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;

public interface IRegisterService {
	boolean register(String name, String surname, String password);
	
	
	ArrayList<Flight> getAllFlightsByBoardingPass(BoardingPass pass);
}
