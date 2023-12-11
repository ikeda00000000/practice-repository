package com.practice.CustomerManagementSystem.form;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CreateCaseForm{
	private Long caseId;
	private Long customerId;
	private Timestamp caseDate;
	private Long accountId;
	private Long categoryId;
	private String title;
	private String content;
}