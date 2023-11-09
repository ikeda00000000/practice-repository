package com.practice.CustomerManagementSystem.form;

import lombok.Data;

@Data
public class CreateCustomerForm{
	private String customerName;
	
	// フォームからは0・1を送るためint型
	private int individual;
	
	private String birth;
	
	private String zip;
	
	private String address;
	
	private String tel;
	
	private String mail;
	
	private int accountId;
	
}