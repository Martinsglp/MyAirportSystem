package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Admin;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.VIPUser;
import com.example.demo.models.enums.userType;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.repos.IVIPUserRepo;
import com.example.demo.service.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IRegisteredUserRepo registRepo;
	
	@Autowired
	IVIPUserRepo vipRepo;
	
	@Autowired
	IBoardingPassRepo boardRepo;
	
	@Override
	public boolean registerAdmin(String username, String password, String name, String surname, String email, userType type) {
		if(adminRepo.existsByNameAndSurnameAndPassword(name, surname, password)) {
			adminRepo.save(new Admin(username, password, name, surname, email, type));
			return true;
		}
		return false;
	}

	@Override
	public boolean authorise(Admin admin) {
		if(adminRepo.existsByUsernameAndPassword(admin.getUsername(), admin.getPassword())) {
			return true;
		}
		return false;
	}
	
	@Override
	public ArrayList<RegisteredUser> selectAllRegisteredUsers() {
		return (ArrayList<RegisteredUser>) registRepo.findAll();
	}

	@Override
	public ArrayList<Flight> selectAllFlights() {
		return (ArrayList<Flight>) flightRepo.findAll();
	}

	@Override
	public ArrayList<BoardingPass> selectAllBoardingPasses() {
		return (ArrayList<BoardingPass>) boardRepo.findAll();
	}

	@Override
	public ArrayList<VIPUser> selectAllVIPUsers() {
		return (ArrayList<VIPUser>) vipRepo.findAll();
	}

	@Override
	public boolean deleteFlightById(int id) {
		if(id > 0) {
			if(flightRepo.existsById(id));
			flightRepo.deleteById(id);
			return true;
		}
		return false;
	}



}
