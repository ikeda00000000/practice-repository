package com.practice.CustomerManagementSystem.form;

import lombok.Data;

@Data
public class CreateCustomerForm{
	private String customerName;
	
	private boolean individual;
	
	private String birth;
	
	private String zip;
	
	private String address;
	
	private String tel;
	
	private String mail;
	
	private Long accountId;
	
}