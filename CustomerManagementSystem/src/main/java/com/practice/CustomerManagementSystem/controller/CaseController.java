package com.practice.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.CustomerManagementSystem.entity.Account;
import com.practice.CustomerManagementSystem.service.FindByKeywordService;
import com.practice.CustomerManagementSystem.service.GetAllAccountsService;
import com.practice.CustomerManagementSystem.service.CRUD.CreateCustomerService;
import com.practice.CustomerManagementSystem.service.CRUD.DeleteCustomerService;
import com.practice.CustomerManagementSystem.service.CRUD.GetAllCustomersService;
import com.practice.CustomerManagementSystem.service.CRUD.UpdateCustomerFormService;

@Controller
@RequestMapping("/")
public class CaseController {

	@Autowired
	private GetAllCustomersService getAllCustomersService;

	@Autowired
	private FindByKeywordService findByKeywordService;

	@Autowired
	private GetAllAccountsService getAllAccountsService;
	
	@Autowired
	private CreateCustomerService createCustomerService;
	
	@Autowired
	private UpdateCustomerFormService updateCustomerFormService; 
	
	@Autowired
	private DeleteCustomerService customerDeleteService;

	
//	// ログイン成功時の共通画面
//	@GetMapping("top")
//	public String top(@AuthenticationPrincipal User user, Model model) {
//		List<Customer> customers = getAllCustomersService.getAllCustomers();
//		// ログイン中のセッションユーザー情報をviewに渡す
//		model.addAttribute("user", user);
//		model.addAttribute("customers", customers);
//		return "top";
//	}
	
	// 担当者のプルダウンを作成するメソッド
	public void makePullDown(Model model) {
		List<Account> accountList = getAllAccountsService.getAllAccounts();
		model.addAttribute("accountList", accountList);
	}

}
