package com.practice.CustomerManagementSystem.service.CASE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.CustomerManagementSystem.entity.Category;
import com.practice.CustomerManagementSystem.mapper.CategoryMapper;

@Service
public class GetAllCategoriesService{
	
	@Autowired
	private CategoryMapper mapper;
	
	@Transactional
	public List<Category> getAllCategories(){
		return mapper.findAll();
	}
}