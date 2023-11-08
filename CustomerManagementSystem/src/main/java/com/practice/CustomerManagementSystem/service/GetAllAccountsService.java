package com.practice.CustomerManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Account;
import com.practice.CustomerManagementSystem.mapper.UserMapper;

@Service
public class GetAllAccountsService{
	
	@Autowired
	private UserMapper mapper;
	
	@Transactional
	public List<Account> getAllAccounts(){
		return mapper.findAll();
	}
}