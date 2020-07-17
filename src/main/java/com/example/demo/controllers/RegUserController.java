package com.example.demo.controllers;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Flight;
import com.example.demo.service.IFlightService;
import com.example.demo.service.IRegisterService;

@Controller
@RequestMapping("/regUser")
public class RegUserController {
	
	@Autowired
	IRegisterService regService;
	
	@Autowired
	IFlightService flightService;
	
	
	@GetMapping("/test")
	public String test() {
		return "hello-page";
	}
	
	
	
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
}
