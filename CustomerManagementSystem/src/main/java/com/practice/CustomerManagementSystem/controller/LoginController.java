package com.practice.CustomerManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

	// "/"にリクエストがあったら
	@GetMapping("login/index")
	public String index() {
		// ログインフォームを提供する
		return "/login/index";
	}

	// ROLEがUSERのみ
	@GetMapping("user")
	public String user() {
		return "user";
	}

	// ROLEがADMINのみ
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
}
