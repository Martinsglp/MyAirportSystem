package com.example.demo;

import com.example.demo.models.*;
import com.example.demo.models.enums.AirportList;
import com.example.demo.models.enums.userType;
import com.example.demo.repos.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class MyAirportSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAirportSystemApplication.class, args);
	}

	@Bean // norada visus repo, kurus grib izmantot datu saglabasanai
	public CommandLineRunner testingDataLoader(IAdminRepo adminRepo, IAirportRepo airportRepo,
											   IBoardingPassRepo boardingPassRepo, IFlightRepo flightRepo,
											   IRegisteredUserRepo registeredUserRepo, ISeatRepo seatRepo) {

		return (args) -> {
			Admin a1 = new Admin("Patriots", "123", "Janis", "Laivinieks", "laivinieks@gmail.com", userType.ADMIN);
			Admin a2 = new Admin("Stiprinieks", "123", "Peteris", "Celajs", "pcelajs@gmail.com", userType.ADMIN);
			adminRepo.save(a1);
			adminRepo.save(a2);

			Airport ap1 = new Airport(AirportList.Igark_Airport, 5);
			Airport ap2 = new Airport(AirportList.Gabbs_Airport, 4);
			airportRepo.save(ap1);
			airportRepo.save(ap2);
			//TODO huh?

			Flight f1 = new Flight(LocalDateTime.now().plusDays(1), 1, AirportList.Anahim_Lake_Airport, AirportList.Bilaspur_Airport, 222);
			Flight f2 = new Flight(LocalDateTime.now().plusDays(3), 5, AirportList.Carauari_Airport, AirportList.Daru_Airport, 190);
			Flight f3 = new Flight(LocalDateTime.now().plusDays(2), 3, AirportList.Bella_Coola_Airport, AirportList.Hasvik_Airport, 133);
			Flight f4 = new Flight(LocalDateTime.now().plusDays(4), 2, AirportList.Eagle_Airport, AirportList.Vilnius_Airport, 190);
			Flight f5 = new Flight(LocalDateTime.now().plusDays(10), 2, AirportList.Eagle_Airport, AirportList.Vilnius_Airport, 190);

			flightRepo.save(f1);
			flightRepo.save(f2);
			flightRepo.save(f3);
			flightRepo.save(f4);
			flightRepo.save(f5);

			RegisteredUser ru1 = new RegisteredUser("Batuts", "123", "Valdis", "Bertrups", "bertrupsvaldis@inbox.lv", 45, false, userType.USER);
			RegisteredUser ru2 = new RegisteredUser("Bosiks", "123", "Tjomka", "Lidotajs", "tjomkal@inbox.lv", 0, false, userType.USER);
			RegisteredUser ru3 = new RegisteredUser("dzelzinieks", "123", "Toms", "Plavinieks", "Plavinieks@inbox.lv", 0, false, userType.USER);
			registeredUserRepo.save(ru1);
			registeredUserRepo.save(ru2);
			registeredUserRepo.save(ru3);


			Seat s1 = new Seat('A', (short)14);
			Seat s2 = new Seat('A', (short)11);
			Seat s3 = new Seat('F', (short)20);
			Seat s4 = new Seat('D', (short)45);

			seatRepo.save(s1);
			seatRepo.save(s2);
			seatRepo.save(s3);
			seatRepo.save(s4);

			BoardingPass bp1 = new BoardingPass(false, false, ru1, f1, s1);
			BoardingPass bp2 = new BoardingPass(true, false, ru2, f1, s2);
			BoardingPass bp3 = new BoardingPass(true, false, ru3, f3, s3);

			boardingPassRepo.save(bp1);
			boardingPassRepo.save(bp2);
			boardingPassRepo.save(bp3);

//		Collection<BoardingPass> boardingPassCollection = new HashSet();
//		boardingPassCollection.add(bp1);
//		boardingPassCollection.add(bp2);
//		boardingPassCollection.add(bp3);

		};
	}
}
