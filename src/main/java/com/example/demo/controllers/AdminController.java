package com.example.demo.controllers;

import com.example.demo.forms.StatisticsForm;
import com.example.demo.models.Flight;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping ("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @Autowired
    IFlightService flightService;

    @GetMapping("") // url: localhost:8080/admin
    public String showAdminStartPage() {
        return "admin-start-page";
    }

    @GetMapping("/showAllFlights") // url: localhost:8080/admin/showAllFlights
    public String getShowAllFlights(Model model) {
        model.addAttribute("allFlights", adminService.selectAllFlights());
        return "show-all-flights-page";
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
