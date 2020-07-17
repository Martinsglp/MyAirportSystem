package com.example.demo.controllers;

import com.example.demo.forms.StatisticsForm;
import com.example.demo.models.Flight;

import com.example.demo.models.RegisteredUser;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IAirportService;

import com.example.demo.service.IFlightService;
import com.example.demo.service.IRegisterService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping ("/admin")
public class AdminController {

    @Autowired
    IFlightService flightService;
    
    @Autowired
    IAirportService airportService;
    
    @Autowired
    IAdminService adminService;
    
    @Autowired
    IRegisterService regService;
    
    @Autowired
	PasswordEncoder encoder;
    

    @GetMapping("") // url: localhost:8080/admin
    public String showAdminStartPage() {
        return "admin-start-page";
    }

    @GetMapping("/showAllFlights") // url: localhost:8080/admin/showAllFlights
    public String getShowAllFlights(Model model) {
        model.addAttribute("allFlights", adminService.selectAllFlights());
        return "show-all-flights-page";
    }
    
    @GetMapping("/showAllUsers")
    public String getShowAllUsers(Model model) {
    	model.addAttribute("allRegisteredUsers", adminService.selectAllRegisteredUsers());
    	return "show-all-users-page";
    }
    
    @GetMapping("/register")
    public String getRegisterUser(RegisteredUser registeredUser) {
    	return "register-one-user-page";
    }
    
    @PostMapping("/register")
    public String postRegisterUser(@Valid RegisteredUser registeredUser, BindingResult result) {
    	System.out.println(registeredUser);
    	
    	System.out.println(registeredUser.getUsername());
    	
    	if(result.hasErrors()) {
    		return "register-one-user-page";
    	}
    	
    	adminService.registerUser(registeredUser.getUsername(),
    			encoder.encode(registeredUser.getPassword()),
    							registeredUser.getName(),
    							registeredUser.getSurname(),
    							registeredUser.getEmail(),
    							registeredUser.getExtra_points(),
    							registeredUser.isVIP(),
    							registeredUser.getUserAutority());
    	return "redirect:/admin/showAllUsers";

    	
    }
    
    
    @GetMapping("/registerNewFlight") // url: localhost:8080/admin/registerNewFlight
    public String getRegisterNewFlight (Flight flight) {
        return "register-new-flight-page";
    }

    @PostMapping("/registerNewFlight")
    public String postRegisterNewFlight(Flight flight) {
        System.out.println(flight.getCreationDateTime());
        flightService.registerFlight(flight.getCreationDateTime(), flight.getDuration(),
                                    flight.getAirportFrom(), flight.getAirportTo(), flight.getFlightPrice());

        return  "redirect:/admin/showAllFlights";
    }

    
    @GetMapping("/checkIfVip")
    public String getCheckIfVip(Model model) {
    	regService.checkIfUserIsViP(adminService.selectAllRegisteredUsers());
    	
    	model.addAttribute("allRegisteredUsers", adminService.selectAllVipRegisteredUsers());
    	return "show-all-users-page";
    }
    
    
    @GetMapping("/updateFlight/{id}")
	public String getUpdateFlight(@PathVariable(name = "id")int id, Model model, Flight flight) {
		try {
			Flight flightForUpdate = flightService.selectOneFlightById(id);
			model.addAttribute("flight", flightForUpdate);
			System.out.println("update");
			return "update-one-flight-page";
		} catch (Exception e) {
			return "error";
		}
	}    
    
	@PostMapping("/updateFlight/{id}")
	public String postUpdate(@PathVariable(name = "id") int id, Flight flight/*, BindingResult result*/) {
		System.out.println(id);
		System.out.println(flight);
		/*
		if(result.hasErrors()) {
			return "update-one-product-page";
		}*/
		flightService.updateFlightObjectById(id, flight);
		return "redirect:/admin/showAllFlights";
		
	}
    
    @GetMapping("/deleteFlight/{id}")
	public String getDelete(@PathVariable(name = "id")int id, Model model) {
		if(flightService.deleteFlightById(id)) {
			model.addAttribute("innerObject");
			return "redirect:/admin/showAllFlights";
		}
		return "error";
	}
    

    @GetMapping("/showStatistics") // url: localhost:8080/admin/showStatistics
    public String getShowStatistics(Model model) {
        model.addAttribute("allFlights", adminService.selectAllFlights());
        model.addAttribute("statisticsForm", new StatisticsForm());
        return "show-statistics-page";
    }

    @PostMapping("/showStatistics")
    public String postShowStatistics(@ModelAttribute StatisticsForm statisticsForm, Model model) {
        model.addAttribute("allFlights", adminService.selectAllFlights());
        model.addAttribute("statisticsForm", new StatisticsForm());
        List<Flight> allFlightsByDates = flightService.getAllFlightsByDate(statisticsForm.getCreationDateTime());
        model.addAttribute("statistics", allFlightsByDates);
        return "show-statistics-page";
    }

}
