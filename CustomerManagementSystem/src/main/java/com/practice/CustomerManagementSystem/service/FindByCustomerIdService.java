package com.practice.CustomerManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.mapper.CustomerMapper;

@Service
public class FindByCustomerIdService{
	
	@Autowired
	private CustomerMapper mapper;
	
	@Transactional
	public Customer findByCustomerId(Long id){
		return mapper.findByCustomerId(id);
	}
}