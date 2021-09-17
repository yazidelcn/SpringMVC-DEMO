package com.elnyazid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@RequestMapping("/user")
public class HomeController {
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/signup")
	public String showForm() {
		return "signUpForm";
	}
	
	@PostMapping("/signup")
	public String signedUp() {
		return "result";
	}
}
