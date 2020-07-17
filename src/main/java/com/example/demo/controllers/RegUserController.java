package com.example.demo.controllers;

import com.example.demo.forms.BookAFlightForm;
import com.example.demo.models.Flight;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.IRegisterService;

import java.util.List;

@Controller
@RequestMapping("/regUser")
public class RegUserController {
	
	@Autowired
	IRegisterService regService;

	@Autowired
	IAdminService adminService;

	@Autowired
	IFlightService flightService;

	@GetMapping("/{id}")
	public String showRegUserStartPage(@PathVariable(name="id") int id, Model model){
		model.addAttribute("id", id);
		return "regUser-start-page";
	}

	@GetMapping("/bookAFlight/{id}")
	public String getBookAFlight(@PathVariable(name="id") int id, Model model) {
		model.addAttribute("allFlights", adminService.selectAllFlights());
		model.addAttribute("bookAFlightForm", new BookAFlightForm());
		return "book-a-flight-page";
	}

	@PostMapping("/bookAFlight/{id}")
	public String postBookAFlight(@PathVariable(name="id") int id, @ModelAttribute BookAFlightForm bookAFlightForm, Model model) {
//		model.addAttribute("allFlights", adminService.selectAllFlights());
//		model.addAttribute("bookAFlightForm", new BookAFlightForm());
		List<Flight> allFlightsByDates = flightService.getAllFlightsByDate(bookAFlightForm.getCreationDateTime());
//		model.addAttribute("bookedFlight", allFlightsByDates);
		regService.bookAFlight(id, bookAFlightForm.getCreationDateTime(), bookAFlightForm.getAirportFrom(), bookAFlightForm.getAirportTo());
//		return "redirect:/regUser/showAllChosenFlights";
		return "regUser-start-page";
	}

//
//	@GetMapping("/showAllChosenFlights") // TODO show list of flight
//	public String getUserChosenFlights(@ModelAttribute BookAFlightForm bookAFlightForm, Model model) {
//		model.addAttribute("allFlights", regService.getAllFlightsByAirports(bookAFlightForm.getAirportFrom(), bookAFlightForm.getAirportTo()));
//		model.addAttribute("allFlightsForm", new BookAFlightForm());
//		List<Flight> allFlightsByAirports =  regService.getAllFlightsByAirports(bookAFlightForm.getAirportFrom(), bookAFlightForm.getAirportTo());
//		model.addAttribute("flights", allFlightsByAirports);
//		return "show-all-regUser-chosen-flights";
//	}


	
}
