package com.example.demo.controllers;

import com.example.demo.models.Flight;
import com.example.demo.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping ("/admin")
public class AdminController {

    @Autowired
    IFlightService flightService;

    @GetMapping("/showAllFlights") // url: localhost:8080/admin/showAllFlights
    public String getShowAllFlights(Model model) {
        model.addAttribute("allFlights", flightService.selectAllFlights());
        return "show-all-flights-page";
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
			model.addAttribute("innerObject", flightService.selectAllFlights());
			return "show-all-flights-page";
		}
		return "error";
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
