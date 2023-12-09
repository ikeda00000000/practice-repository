package com.practice.CustomerManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.form.UpdateCustomerForm;
import com.practice.CustomerManagementSystem.mapper.CustomerMapper;

@Service
public class PrepareUpdateCustomerFormService{
	
	@Autowired
	private CustomerMapper mapper;
	
	@Transactional
	public UpdateCustomerForm prepareUpdateCustomerForm(Long id){
		Customer customer = mapper.findByCustomerId(id);
		UpdateCustomerForm form = new UpdateCustomerForm();
		form.setCustomerId(customer.getCustomerId());
		form.setCustomerName(customer.getCustomerName());
		// customerはboolean型なので個人=true→1、法人=false→0に変換して詰める
		if(customer.isIndividual()) {
			form.setIndividual(1);
		} else {
			form.setIndividual(0);
		}
		form.setBirth(customer.getBirth());
		form.setZip(customer.getZip());
		form.setAddress(customer.getAddress());
		form.setTel(customer.getTel());
		form.setMail(customer.getMail());
		form.setAccountId(customer.getAccountId());
		// isdeletedはそもそも一覧表示されないので必ず0
		return form;
		
	}
	
}