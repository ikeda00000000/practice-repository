package com.practice.CustomerManagementSystem.entity;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Case{
	
	private Long caseId;
	private Long customerId;
	private Customer customer;
	private Timestamp caseDate;
	private Long accountId;
	private Account account;
	private Long categoryId;
	private Category category;
	private String title;
	private String content;
	private boolean isDeleted;
	
	
}