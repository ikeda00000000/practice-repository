package com.practice.CustomerManagementSystem.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.CustomerManagementSystem.entity.Category;

@Mapper
public interface CategoryMapper {
 
    // 全件取得
	List<Category> findAll();
    
}
