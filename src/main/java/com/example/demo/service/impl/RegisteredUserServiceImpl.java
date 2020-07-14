package com.example.demo.service.impl;

import java.util.ArrayList;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.enums.userType;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.service.IRegisterService;

public class RegisteredUserServiceImpl implements IRegisterService{

	@Autowired
	IRegisteredUserRepo regRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IBoardingPassRepo boardRepo;
	
	@Override
	public boolean registerRegUser(String username, String password, String name, String surname, String email, userType type) {
		if(regRepo.existsByNameAndSurnameAndPassword(name, surname, password)) {
			regRepo.save(new RegisteredUser(username, password, name, surname, email, 0, type));
			return true;
		}
		return false;
	}
	
	@Override
	public BoardingPass selectOneBoardingPassById(int id) throws Exception {
		if(id > 0) {
			if(boardRepo.existsById(id)) {
				return boardRepo.findById(id).get();
			}
		}
		throw new Exception("Id not valid!");
	}

	@Override
	public ArrayList<BoardingPass> getAllFlightsByBoardingPass(BoardingPass pass) throws Exception {
		if(boardRepo.existsById(pass.getBp_ID())) {
			BoardingPass temp = boardRepo.findById(pass.getBp_ID()).get();
			ArrayList<BoardingPass> allFlightsByBoardingPass = flightRepo.findByBoardingPasses(temp);
			return allFlightsByBoardingPass;
		}
		throw new Exception("BoardingPass not found!!");
	}


	




	

	
}
