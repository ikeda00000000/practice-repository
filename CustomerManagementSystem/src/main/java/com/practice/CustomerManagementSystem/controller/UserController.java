package com.practice.CustomerManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController{
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("common")
	public String common() {
			return "common";
		}
	
	@GetMapping("user")
	public String user() {
		return "user";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}

	
	
}


