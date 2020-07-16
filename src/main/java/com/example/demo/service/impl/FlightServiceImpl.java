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
	public Flight selectOneFlightById(int id) throws Exception {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				return flightRepo.findById(id).get();
			}
		}
		throw new Exception("Id not valid!");
	}

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
	public boolean updateFlightById(int id, LocalDateTime dateAndTime, int duration, AirportList airportFrom,
			AirportList airportTo, double flightPrice, Flight flight) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				Flight flightToUpdate = flightRepo.findById(id).get();
				flightToUpdate.setCreationDateTime(dateAndTime.withNano(0));
				flightToUpdate.setDuration(duration);
				flightToUpdate.setAirportFrom(airportFrom);
				flightToUpdate.setAirportTo(airportTo);
				flightToUpdate.setFlightPrice(flightPrice);
				flightRepo.save(flightToUpdate);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateFlightObjectById(int id, Flight flight) {
		if(flightRepo.existsById(id)) {
			Flight temp = flightRepo.findById(flight.getFl_ID()).get();
			temp.setCreationDateTime(flight.getCreationDateTime());
			temp.setDuration(flight.getDuration());
			temp.setAirportFrom(flight.getAirportFrom());
			temp.setAirportTo(flight.getAirportTo());
			temp.setFlightPrice(flight.getFlightPrice());
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

	@Override
	public ArrayList<Flight> getAllFlightsByDate(LocalDateTime creationDateTime) {
		System.err.println(creationDateTime);
    	ArrayList<Flight> allFlights = (ArrayList<Flight>)flightRepo.findAll();
    	ArrayList<Flight> allFlightsByDate = new ArrayList<>();
    	for (Flight f : allFlights) {
			System.err.println(f);
    		if (f.getCreationDateTime().getDayOfYear() == (creationDateTime.getDayOfYear())) {
				System.out.println("********************************************");
				allFlightsByDate.add(f);
			}
		}
    	return allFlightsByDate;
	}
    
}
