package com.practice.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.CustomerManagementSystem.entity.Account;
import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.entity.User;
import com.practice.CustomerManagementSystem.form.CreateCustomerForm;
import com.practice.CustomerManagementSystem.form.UpdateCustomerForm;
import com.practice.CustomerManagementSystem.service.CreateCustomerService;
import com.practice.CustomerManagementSystem.service.FindByKeywordService;
import com.practice.CustomerManagementSystem.service.GetAllAccountsService;
import com.practice.CustomerManagementSystem.service.GetAllCustomersService;
import com.practice.CustomerManagementSystem.service.UpdateCustomerFormService;

@Controller
@RequestMapping("/")
public class UserController {

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

	// "/"にリクエストがあったら
	@GetMapping("login/index")
	public String index() {
		// ログインフォームを提供する
		return "/login/index";
	}

	// ログイン成功時の共通画面
	@GetMapping("top")
	public String top(@AuthenticationPrincipal User user, Model model) {
		List<Customer> customers = getAllCustomersService.getAllCustomers();
		// ログイン中のセッションユーザー情報をviewに渡す
		model.addAttribute("user", user);
		model.addAttribute("customers", customers);
		return "top";
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

	// キーワード検索
	@GetMapping("top/search")
	public String search(@AuthenticationPrincipal User user,@RequestParam("searchByKeyword") String keyword, Model model) {

		//受け取ったkeywordで部分一致するユーザーを返すServiceを呼び出す
		List<Customer> customersMatchedKeyword = findByKeywordService.findByKeyword(keyword);
		model.addAttribute("customers", customersMatchedKeyword);
		model.addAttribute("user", user);

		return "top";
	}

	// 新規登録画面へアクセス
	@GetMapping("customer/create")
	public String customerCreate(Model model) {
		// 担当者プルダウンに必要な情報をmodelに渡す
		makePullDown(model);
		model.addAttribute("form", new CreateCustomerForm());

		return "customer/create";
	}

	// 新規登録フォームの内容をDBへ反映
	@PostMapping("customer/create")
	public String customerCreate(@Validated @ModelAttribute("form") CreateCustomerForm form, BindingResult result,  Model model) {
		
		// viewから送られてきたmodelにエラーがあるかチェック、あればviewに戻す
		if(result.hasErrors()) {
			makePullDown(model);
			model.addAttribute("form", form);
			return "customer/create";
		}
		createCustomerService.create(form);
		
		// ホーム画面へ戻す。/をつけないと404エラー
		return "redirect:/top";
		
	}
	
	// 編集画面へアクセス
	@GetMapping("customer/update/{customerId}")
	public String customerUpdate(@PathVariable("customerId") Long customerId, Model model) {
		makePullDown(model);
		UpdateCustomerForm form = updateCustomerFormService.prepareForm(customerId);
		model.addAttribute("form", form);
		return "customer/update";
	}
	
	@PostMapping("customer/update/{customerId}")
	public String customerUpdate(@PathVariable("customerId") Long customerId, @Validated @ModelAttribute("form") UpdateCustomerForm form, BindingResult result, Model model) {
	    if(result.hasErrors()) {
	    	makePullDown(model);
	    	model.addAttribute("form", form);
	    	return "customer/update";
	    }
	    updateCustomerFormService.update(form);
	    return "redirect:/top";
	}
	
	// 担当者のプルダウンを作成するメソッド
	public void makePullDown(Model model) {
		List<Account> accountList = getAllAccountsService.getAllAccounts();
		model.addAttribute("accountList", accountList);
	}

}
