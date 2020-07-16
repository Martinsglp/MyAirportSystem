package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IRegisterService;

@Controller
@RequestMapping("/regUser")
public class RegUserController {
	
	@Autowired
	IRegisterService regService;
	
	
	@GetMapping("/test")
	public String test() {
		return "hello-page";
	}
	
	
}
