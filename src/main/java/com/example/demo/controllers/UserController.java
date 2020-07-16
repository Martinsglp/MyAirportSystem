package com.example.demo.controllers;

import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.service.IAirportService;
import com.example.demo.service.IFlightService;
import com.example.demo.service.IRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class UserController {

    @Autowired
    IFlightService flightService;

    @Autowired
    IAirportService airportService;
    
    @Autowired
    IRegisterService regService;
/*
    @GetMapping("/register")
    public String getRegisterUser(RegisteredUser regUser) {
    	return "insert-one-user-page";
    }
    
    @PostMapping("/register")
    public String postRegisterUser(@Valid RegisteredUser regUser, BindingResult result) {
    	System.out.println(regUser);
    	
    	if(result.hasErrors()) {
    		return "insert-one-user-page";
    	}
    	
    	regService.registerRegUser(regUser.getUsername(), regUser.getPassword(), regUser.getName(), regUser.getSurname(), regUser.getEmail(), regUser.getType());
    	//TODO change from admin to user page..
    	return "redirect:/admin/show-all-users-page";
    	
    }
    */
    
    
    
    @GetMapping("/saveTestingData")
    public String getSaveTestingData() {
        System.out.println("saveTestingData");
        airportService.testModelLayer();
        return "hello-page";
    }

    @GetMapping("/showFlightSelectingPage") // url: localhost:8080/guest/showFlightSelectingPage
    public String getShowFlightSelectingPage(Flight flight) { // empty flight for filling data
        return "show-flight-selecting-page";
    }

    @PostMapping("/showFlightSelectingPage")
    public String postShowFlightSelectingPage(@Valid Flight flight, BindingResult result, Model model) {
        System.out.println(flight.getAirportFrom() + " " + flight.getAirportTo());

        if (result.hasErrors()  || flight.getAirportFrom().equals(flight.getAirportTo()) || !flightService.checkIfFlightIsInDB(flight)) {
            return "show-flight-selecting-page";
        }
        List<Flight> selectedFlightsAL = flightService.showSelectedFlightsInfoByAirports(flight.getAirportFrom(), flight.getAirportTo());
        model.addAttribute("allFlightsByAirports", selectedFlightsAL);
        model.addAttribute("byFlightPrice", Comparator.comparing(Flight::getFlightPrice));
        return "show-flights-by-airports-page";
    }
    
    
    
    
    
    
    
}
