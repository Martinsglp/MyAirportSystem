package com.example.demo.service.impl;

import com.example.demo.models.Flight;
import com.example.demo.models.enums.AirportList;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.service.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService{

    @Autowired
    IFlightRepo flightRepo;

    @Override
    public boolean registerFlight(LocalDateTime creationDateTime, int duration, AirportList airportFrom, AirportList airportTo, double flightPrice) {
        if (flightRepo.existsByCreationDateTimeAndDurationAndAirportFromAndAirportTo(creationDateTime, duration, airportFrom, airportTo)) {
            return false;
        }
        flightRepo.save(new Flight(creationDateTime, duration, airportFrom, airportTo, flightPrice));
        return true;
    }

    @Override
    public List<Flight> showSelectedFlightsInfoByAirports(AirportList airportFrom, AirportList airportTo) {
        ArrayList<Flight> allFlights = (ArrayList<Flight>)flightRepo.findAll();
        ArrayList<Flight> allFlightsByAirportInfo = new ArrayList<>();

        if (airportFrom != null && airportTo != null) {
            for (Flight f : allFlights) {
                if (f.getAirportFrom().equals(airportFrom) && f.getAirportTo().equals(airportTo)) {
                    allFlightsByAirportInfo.add(f);
                }

            }
            return allFlightsByAirportInfo;
        }
        return new ArrayList<>();
    }

    @Override
    public void saveTestingData() {
        Flight f1 = new Flight(LocalDateTime.now().plusDays(2), 1, AirportList.Anaa_Airport, AirportList.Anahim_Lake_Airport, 250);
        Flight f2 = new Flight(LocalDateTime.now().plusDays(3), 2, AirportList.Bella_Coola_Airport, AirportList.Bilaspur_Airport, 300);
        Flight f3 = new Flight(LocalDateTime.now().plusDays(4), 3, AirportList.Carauari_Airport, AirportList.Chennai_International_Airport, 150);
        Flight f4 = new Flight(LocalDateTime.now().plusDays(5), 4, AirportList.Daru_Airport, AirportList.Eagle_Airport, 270);
        Flight f5 = new Flight(LocalDateTime.now().plusDays(5), 4, AirportList.Daru_Airport, AirportList.Eagle_Airport, 500);

        flightRepo.save(f1);
        flightRepo.save(f2);
        flightRepo.save(f3);
        flightRepo.save(f4);
        flightRepo.save(f5);
    }

    @Override
    public boolean checkIfFlightIsInDB(Flight flight) {

        if (flightRepo.existsByAirportFromAndAirportTo(flight.getAirportFrom(), flight.getAirportTo())) {
            System.out.println("Flight IS in db");
            return true;
        } else {
            System.out.println("Flight IS NOT in db");
            return false;
        }
    }

    @Override
    public ArrayList<Flight> selectAllFlights() {
        ArrayList<Flight> allFlights = (ArrayList<Flight>)flightRepo.findAll();
        return allFlights;
    }
   
    
	@Override
	public boolean updateFlightById(int id, AirportList airportFrom, AirportList airportTo, Flight flight) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				Flight productToUpdate = flightRepo.findById(id).get();
				productToUpdate.setAirportFrom(airportFrom);
				productToUpdate.setAirportTo(airportTo);
				flightRepo.save(flight);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateFlightObjectById(int id, Flight flight) {
		if(flightRepo.existsById(id)) {
			Flight temp = flightRepo.findById(flight.getFl_ID()).get();
			temp.setAirportFrom(flight.getAirportFrom());
			temp.setAirportTo(flight.getAirportTo());
			temp.setDuration(flight.getDuration());
			flightRepo.save(temp);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteFlightById(int id) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				flightRepo.deleteById(id);
				return true;
			}
		}
		return false;
	}
    

    
}
