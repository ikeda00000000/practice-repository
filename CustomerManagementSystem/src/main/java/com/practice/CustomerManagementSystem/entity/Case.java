package com.practice.CustomerManagementSystem.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Case{
	
	private Long caseId;
	private Long customerId;
	private Customer customer;
	private Date createCaseDate;
	private Long accountId;
	private Account account;
	private Long categoryId;
	private Category category;
	private String title;
	private String content;
	private boolean isDeleted;
	
	
}