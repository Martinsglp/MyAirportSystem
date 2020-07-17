package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/tests")
	public String tests() {
		return "hello-page";
	}
	
	@GetMapping("/{id}")
	public String showRegUserStartPage(@PathVariable(name="id") int id, Model model){
	model.addAttribute("id", id);
	return "regUser-start-page";
	}
	//2020-07-21T14:19:23
	
}
