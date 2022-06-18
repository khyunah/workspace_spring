package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "김현아");
		return "home";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("hi", "<h1>안녕~!</h1>");
		return "hello";
	}
}
