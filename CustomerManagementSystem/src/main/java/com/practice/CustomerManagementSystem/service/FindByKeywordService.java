package com.practice.CustomerManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.mapper.CustomerMapper;

@Service
public class FindByKeywordService{
	
	@Autowired
	private CustomerMapper mapper;
	
	@Transactional
	public List<Customer> findByKeyword(String keyword){
		return mapper.findByKeyword(keyword);
	}
}