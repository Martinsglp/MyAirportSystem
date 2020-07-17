package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import com.example.demo.models.Flight;
import com.example.demo.models.Seat;
import com.example.demo.models.enums.AirportList;
import com.example.demo.repos.ISeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.enums.userType;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IRegisterService;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserServiceImpl implements IRegisterService{

	@Autowired
	IRegisteredUserRepo regRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IBoardingPassRepo boardRepo;

	@Autowired
	IRegisterService registerService;

	@Autowired
	ISeatRepo seatRepo;
	
	@Autowired
	IAdminService adminService;
	
	@Override
	public boolean registerRegUser(String username, String password, String name, String surname, String email, userType type) {
		if(!regRepo.existsByNameAndSurnameAndPassword(name, surname, password)) {
			regRepo.save(new RegisteredUser(username, password, name, surname, email, 0, false, userType.USER));
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

	@Override
	public ArrayList<Flight> getAllFlightsByAirports(AirportList from, AirportList to) {
		ArrayList<Flight> allFlights = flightRepo.findByAirportFromAndAirportTo(from, to);
		return allFlights;
	}

	@Override
	public boolean checkIfUserIsViP(Collection<RegisteredUser> registeredUsers) {
		int minimumReq = 40;

		for(RegisteredUser reg : registeredUsers) {
			RegisteredUser temp = regRepo.findByUsername(reg.getUsername());
			if(temp.getExtra_points() >= minimumReq){
				temp.setType(userType.VIP);
				temp.setVIP(true);
				regRepo.save(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkIfOneUserIsViP(RegisteredUser registeredUser) {
		int minimumReq = 40;

		for (RegisteredUser reg : regRepo.findAll()){
			RegisteredUser temp = regRepo.findByUsername(reg.getUsername());
			if (temp.getExtra_points() >= minimumReq) {
				temp.setType(userType.VIP);
				temp.setVIP(true);
				regRepo.save(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean bookAFlight(int userID, LocalDateTime dateTime, AirportList nameFrom, AirportList nameTo) {
			if (regRepo.existsById(userID)) {
				LocalDateTime startTime = dateTime.withSecond(0).withMinute(0).withHour(0);
				LocalDateTime endTime = dateTime.withSecond(59).withMinute(59).withHour(23);

				RegisteredUser rus = regRepo.findById(userID).get();
				boolean priorityGroupForRus = registerService.checkIfOneUserIsViP(rus);


				Seat seat = new Seat('A', (short)56); // TODO seat by priority
				seatRepo.save(seat);

				ArrayList<Flight> allFlights = flightRepo.findByAirportFromAndAirportTo(nameFrom, nameTo);
				for (Flight f : allFlights) {
					if (f.getCreationDateTime().getYear() == dateTime.getYear() && f.getCreationDateTime().getMonth() == dateTime.getMonth()
							&& f.getCreationDateTime().getDayOfMonth() == dateTime.getDayOfMonth()) {
						System.out.println("Datums atrasts");
						BoardingPass boardingPass = new BoardingPass(priorityGroupForRus, false, rus, f, seat);
						boardRepo.save(boardingPass);
						return true;
					}
				}
			}
		return false;
	}
	
	@Override
	public boolean earnExtraPoints(BoardingPass bp, RegisteredUser ru) {
//		if (bp.ex)
		return false;
	}

	@Override
	public boolean checkIn(BoardingPass boardingPass) {
		if(boardRepo.existsById(boardingPass.getBp_ID())) {
			if(boardingPass.isCheckIn() == false) {
				boardingPass.setCheckIn(true);
				boardRepo.save(boardingPass);
				return true;
			}
			
		}
		return false;
	}

	@Override
	public BoardingPass getBoardingPassByUserId(int id) throws Exception {
		ArrayList<BoardingPass> allPasses = adminService.selectAllBoardingPasses();
		
		for(BoardingPass bp : allPasses) {
			if(bp.getRegisteredUser().getRus_ID() == id) {
				return bp;
			}
		}
		throw new Exception("Invalid id!");
	}

	



	

	
}
