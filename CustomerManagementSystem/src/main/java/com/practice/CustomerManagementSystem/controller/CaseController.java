package com.practice.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.CustomerManagementSystem.entity.Account;
import com.practice.CustomerManagementSystem.entity.Case;
import com.practice.CustomerManagementSystem.entity.Category;
import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.form.CreateCaseForm;
import com.practice.CustomerManagementSystem.service.GetAllAccountsService;
import com.practice.CustomerManagementSystem.service.CASE.CaseService;
import com.practice.CustomerManagementSystem.service.CASE.GetAllCategoriesService;
import com.practice.CustomerManagementSystem.service.CRUD.GetOneCustomersService;

@Controller
@RequestMapping("/")
public class CaseController {

	@Autowired
	private CaseService caseService;

	@Autowired
	private GetAllAccountsService getAllAccountsService;
	
	@Autowired
	private GetOneCustomersService getOneCustomersService;
	
	@Autowired
	private GetAllCategoriesService getAllCategoriesService;
	
	@GetMapping("case/case_index")
	public String caseIndex(@RequestParam("customerId") Long customerId, Model model) {
		List<Case> cases = caseService.getCases(customerId);
		model.addAttribute("customerId", customerId);
		model.addAttribute("cases", cases);
		return "/case/case_index";
		
	}
	
	@GetMapping("case/case_create")
	public String caseCreate(@RequestParam("customerId") Long customerId, Model model) {
		// 戻るボタンのためだけにmodel.addAttributeするの違うような？？
		model.addAttribute("customerId", customerId);
		// customersの情報を引っ張ってくる
		Customer customer = getOneCustomersService.getOne(customerId);
		model.addAttribute("customer", customer);
		model.addAttribute("form", new CreateCaseForm());
		makeAccountPullDown(model);
		makeCategoryPullDown(model);
		return "/case/case_create";
	}
	
	@PostMapping("case/case_create")
	public String caseCreate() {
		return "/case/case_index";
	}
	
	// 担当者のプルダウンを作成するメソッド
	public void makeAccountPullDown(Model model) {
		List<Account> accountList = getAllAccountsService.getAllAccounts();
		model.addAttribute("accountList", accountList);
	}
	
	// カテゴリーのプルダウンを作成するメソッド
	public void makeCategoryPullDown(Model model) {
		List<Category> categoryList = getAllCategoriesService.getAllCategories();
		model.addAttribute("categoryList", categoryList);
	}
}
