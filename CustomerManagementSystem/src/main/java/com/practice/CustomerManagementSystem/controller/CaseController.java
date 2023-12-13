package com.practice.CustomerManagementSystem.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

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

//	@Autowired
//	private ExportToExcelService exportToExcelService;

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

	// Excel出力機能
	@PostMapping("case/export_excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.addHeader("Content-Disposition", "attachment; filename=\"sample.xlsx\"");
		try (ServletOutputStream stream = response.getOutputStream()) {
			// xlsx形式のブックの生成
			XSSFWorkbook wb = new XSSFWorkbook();
			// sheetの作成
			XSSFSheet sheet = wb.createSheet();
			// 行・セルの生成
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);

			try {
				cell.setCellValue("テスト出力");
				wb.write(stream);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					wb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
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
