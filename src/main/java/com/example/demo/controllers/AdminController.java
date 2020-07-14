package com.example.demo.controllers;

import com.example.demo.models.Flight;
import com.example.demo.service.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping ("/admin")
public class AdminController {

    @Autowired
    IFlightService flightService;

    @GetMapping("/registerNewFlight") // url: localhost:8080/admin/registerNewFlight
    public String getRegisterNewFlight (Flight flight) {
        return "register-new-flight-page";
    }

    @PostMapping("/registerNewFlight")
    public String postRegisterNewFlight(@Valid Flight flight, BindingResult result) {
        if (result.hasErrors()) {
            return "register-new-flight-page";
        }
        flightService.registerFlight(flight.getCreationDateTime(), flight.getDuration(),
                                    flight.getAirportFrom(), flight.getAirportTo());
        return  "redirect:/flight/showAllFlights";
    }
    
    

}
