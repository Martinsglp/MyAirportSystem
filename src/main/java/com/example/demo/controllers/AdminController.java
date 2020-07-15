package com.example.demo.controllers;

import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IAirportService;
import com.example.demo.service.IFlightService;
import com.example.demo.service.IRegisterService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping("/showAllFlights") // url: localhost:8080/admin/showAllFlights
    public String getShowAllFlights(Model model) {
        model.addAttribute("allFlights", flightService.selectAllFlights());
        return "show-all-flights-page";
    }
    
    @GetMapping("/showAllUsers")
    public String getShowAllUsers(Model model) {
    	model.addAttribute("allRegisteredUsers", adminService.selectAllRegisteredUsers());
    	return "show-all-users-page";
    }
    

    @GetMapping("/registerNewFlight") // url: localhost:8080/admin/registerNewFlight
    public String getRegisterNewFlight (Flight flight) {
        return "register-new-flight-page";
    }

    @PostMapping("/registerNewFlight")
    public String postRegisterNewFlight(Flight flight) {
//        if (result.hasErrors()) {
//            return "register-new-flight-page";
//        }
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
    
    
    

}
