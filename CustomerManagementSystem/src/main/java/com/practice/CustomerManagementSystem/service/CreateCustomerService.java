package com.practice.CustomerManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.form.CreateCustomerForm;
import com.practice.CustomerManagementSystem.mapper.CustomerMapper;

@Service
public class CreateCustomerService{
	
	@Autowired
	private CustomerMapper mapper;
	
	@Transactional
	public int create(CreateCustomerForm form){
		// formの入力内容をCustomerクラスに詰め替える
		Customer customer = new Customer();
		customer.setCustomerName(form.getCustomerName());
		
		/*
		 *  TODO　0か1を値として受け取ってる。どこでboolean型にすべき？？
		 *  フロント側でtrue/falseって送れる？？ここで詰め替える？？
		 *  Customer型をint型にして詰め替える必要性なくす？？
		 */

		if(form.getIndividual() == 1) {
			customer.setIndividual(true);
		} else {
			customer.setIndividual(false);
		}
		
		customer.setBirth(form.getBirth());
		customer.setZip(form.getZip());
		customer.setAddress(form.getAddress());
		customer.setTel(form.getTel());
		customer.setMail(form.getMail());
		customer.setAccountId(form.getAccountId());
		
		return mapper.create(customer);
	}
}