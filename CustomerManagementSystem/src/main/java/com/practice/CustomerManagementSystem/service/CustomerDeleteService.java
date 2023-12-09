package com.practice.CustomerManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.mapper.CustomerMapper;

@Service
public class CustomerDeleteService {
	@Autowired
	CustomerMapper customerMapper;
	
	@Transactional
	public int delete(Long customerId) {
		return customerMapper.delete(customerId);
	}
}
