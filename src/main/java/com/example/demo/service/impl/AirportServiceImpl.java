package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Admin;
import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.enums.AirportList;
import com.example.demo.models.enums.userType;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IAirportRepo;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.repos.ISeatRepo;
import com.example.demo.service.IAirportService;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements IAirportService{

	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IBoardingPassRepo boardRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IRegisteredUserRepo regRepo;
	
	@Autowired
	ISeatRepo seatRepo;
	
	@Autowired
	IAirportRepo airportRepo;
	
	
	
	@Override
	public void testModelLayer() {
		
		Admin a1 = new Admin("Patriots", "123456", "Janis", "Laivinieks", "laivinieks@gmail.com", userType.ADMIN);
		Admin a2 = new Admin("Stiprinieks", "123456", "Peteris", "Celajs", "pcelajs@gmail.com", userType.ADMIN);
		adminRepo.save(a1);
		adminRepo.save(a2);

		Airport ap1 = new Airport(AirportList.Igark_Airport, 5);
		Airport ap2 = new Airport(AirportList.Gabbs_Airport, 4);
		airportRepo.save(ap1);
		airportRepo.save(ap2);
		//TODO huh?
		
//		BoardingPass bp1 = new BoardingPass(false);
//		BoardingPass bp2 = new BoardingPass(true);
//		BoardingPass bp3 = new BoardingPass(true);
//		boardRepo.save(bp1);
//		boardRepo.save(bp2);
//		boardRepo.save(bp3);

		Flight f1 = new Flight(LocalDateTime.now().plusDays(1), 1, AirportList.Anahim_Lake_Airport, AirportList.Bilaspur_Airport, 222);
		Flight f2 = new Flight(LocalDateTime.now().plusDays(3), 5, AirportList.Carauari_Airport, AirportList.Daru_Airport, 190);
		Flight f3 = new Flight(LocalDateTime.now().plusDays(2), 3, AirportList.Bella_Coola_Airport, AirportList.Hasvik_Airport, 133);
		Flight f4 = new Flight(LocalDateTime.now().plusDays(4), 2, AirportList.Eagle_Airport, AirportList.Vilnius_Airport, 190);

		flightRepo.save(f1);
		flightRepo.save(f2);
		flightRepo.save(f3);
		flightRepo.save(f4);
		

		RegisteredUser ru1 = new RegisteredUser("Batuts", "123", "Valdis", "Bertrups", "bertrupsvaldsi@inbox.lv", 40, false, userType.USER);
		RegisteredUser ru2 = new RegisteredUser("Bosiks", "123", "Tjomka", "Lidotajs", "tjomkal@inbox.lv", 0, false, userType.USER);
		RegisteredUser ru3 = new RegisteredUser("Vaditajs", "123", "Arciks", "Smagais", "smagaisVaditajs@transport.com", 50, true, userType.VIP);
		RegisteredUser ru4 = new RegisteredUser("Laivinieks", "123", "Didzis", "Dadzis", "dadzitis@gmail.com", 0, false, userType.USER);
		
		regRepo.save(ru1);
		regRepo.save(ru2);
		regRepo.save(ru3);
		regRepo.save(ru4);

		VIPUser vip1 = new VIPUser("dzelzinieks", "123", "Toms", "Plavinieks", "Plavinieks@inbox.lv", false, userType.VIP);
		VIPUser vip2 = new VIPUser("dizais", "123", "Davis", "Gaisredzis", "gaishais@gmail.com", true, userType.VIP);
		vipRepo.save(vip1);
		vipRepo.save(vip2);

		Seat s1 = new Seat('A', (short)14);
		Seat s2 = new Seat('A', (short)11);
		Seat s3 = new Seat('F', (short)20);
		Seat s4 = new Seat('D', (short)45);

		seatRepo.save(s1);
		seatRepo.save(s2);
		seatRepo.save(s3);
		seatRepo.save(s4);

		BoardingPass bp4 = new BoardingPass(false, ru1, f1, s1);
		BoardingPass bp5 = new BoardingPass(true, ru2, f1, s2);
		BoardingPass bp6 = new BoardingPass(true, ru3, f3, s3);

		boardRepo.save(bp4);
		boardRepo.save(bp5);
		boardRepo.save(bp6);

//		Collection<BoardingPass> boardingPassCollection = new HashSet();
//		boardingPassCollection.add(bp4);
//		boardingPassCollection.add(bp5);
//		boardingPassCollection.add(bp6);


	}

}
