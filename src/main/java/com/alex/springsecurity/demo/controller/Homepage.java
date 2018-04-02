package com.alex.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homepage {
    
        @GetMapping("/")
	public String showHome() {
		
		return "home";
	}
        
        @GetMapping("/homepage")
	public String showHome1() {
		
		return "home";
	}
   
}