package com.example.demo.service.impl;

import java.util.ArrayList;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.User;
import com.example.demo.models.VIPUser;
import com.example.demo.service.IAdminService;

public class AdminServiceImpl implements IAdminService{

	@Override
	public boolean register(String name, String surname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authorise(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<RegisteredUser> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Flight> selectAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardingPass> selectAllBoardingPasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VIPUser> selectAllVIPUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
