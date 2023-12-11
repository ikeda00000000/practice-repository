package com.practice.CustomerManagementSystem.service.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Customer;
import com.practice.CustomerManagementSystem.mapper.CustomerMapper;

@Service
public class GetOneCustomersService{
	/* CustomerMapperをDIしてインスタンス化させる。
	 * でないとgetAllはインスタンスメソッドなので呼び出せない
	 */
	@Autowired
	private CustomerMapper mapper;
	
	// TODO ここでtransactionalをつけるのがよく分からない
	@Transactional
	public Customer getOne(Long id){
		return mapper.findByCustomerId(id);
	}
}