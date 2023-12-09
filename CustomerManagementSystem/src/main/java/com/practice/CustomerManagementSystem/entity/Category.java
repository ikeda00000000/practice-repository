package com.practice.CustomerManagementSystem.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Category{
	
	private Long categoryId;
	private String category;
	private boolean isDeleted;

}