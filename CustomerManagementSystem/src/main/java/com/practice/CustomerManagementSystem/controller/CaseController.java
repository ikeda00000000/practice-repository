package com.practice.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.CustomerManagementSystem.entity.Account;
import com.practice.CustomerManagementSystem.entity.Case;
import com.practice.CustomerManagementSystem.service.GetAllAccountsService;
import com.practice.CustomerManagementSystem.service.CASE.CaseService;

@Controller
@RequestMapping("/")
public class CaseController {

	@Autowired
	private CaseService caseService;

	@Autowired
	private GetAllAccountsService getAllAccountsService;
	


	
//	// ログイン成功時の共通画面
//	@GetMapping("top")
//	public String top(@AuthenticationPrincipal User user, Model model) {
//		List<Customer> customers = getAllCustomersService.getAllCustomers();
//		// ログイン中のセッションユーザー情報をviewに渡す
//		model.addAttribute("user", user);
//		model.addAttribute("customers", customers);
//		return "top";
//	}
	
	@GetMapping("case/case_index")
	public String caseIndex(@RequestParam("customerId") Long customerId, Model model) {
		List<Case> cases = caseService.getCases(customerId);
		model.addAttribute("cases", cases);
		
		return "/case/case_index";
		
	}
	
	// 担当者のプルダウンを作成するメソッド
	public void makePullDown(Model model) {
		List<Account> accountList = getAllAccountsService.getAllAccounts();
		model.addAttribute("accountList", accountList);
	}

}
