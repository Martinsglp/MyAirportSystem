package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.demo.models.*;
import com.example.demo.models.enums.AirportList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.enums.userType;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IRegisteredUserRepo registRepo;
	
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
	public boolean findFlightByDateAndAirports(LocalDateTime dateTime, AirportList nameFrom, AirportList nameTo){
		if (flightRepo.existsByCreationDateTimeAndAirportFromAndAirportTo(dateTime, nameFrom, nameTo)) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<BoardingPass> selectAllBoardingPasses() {
		return (ArrayList<BoardingPass>) boardRepo.findAll();
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
  
	@Override
	public ArrayList<RegisteredUser> selectAllVipRegisteredUsers() {
		return registRepo.findByType(userType.VIP);
	}

<<<<<<< HEAD

=======
	@Override
	public boolean registerUser(String username, String password, String name, String surname, String email, int extra_points, boolean VIP, userType type) {
		System.out.println(extra_points +" "+ VIP +" "+ username);
		
		if(!registRepo.existsByUsername(username)) {
			
			
			
			registRepo.save(new RegisteredUser(username, password, name, surname, email, extra_points, VIP, type));
			return true;
		}
		return false;
	}
>>>>>>> 7a1ca36a6cb6d776329551e7dfb3d9cd9f837101
	
}
