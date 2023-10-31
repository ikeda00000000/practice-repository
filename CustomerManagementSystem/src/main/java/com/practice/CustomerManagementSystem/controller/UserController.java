package com.practice.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.service.GetAllCustomersService;



@Controller
/*
 * "/"にPOSTするとログイン処理が開始
 * "/"はログインページかつ、ログイン失敗時、ログアウト時の遷移先
 * 
 */
@RequestMapping("/")
public class UserController{
	
	@Autowired
	private GetAllCustomersService getAllCustomersService;
	
	// "/"にリクエストがあったら
	@GetMapping
	public String index() {
		return "index";
	}
	
	// ログイン成功時の共通画面
	@GetMapping("common")
	public String common(Model model) {
		// 一覧表示のserviceを呼び出す
		List<Customer> customers= getAllCustomersService.getAllCustomers();
		model.addAttribute("customers", customers);
			return "common";
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


