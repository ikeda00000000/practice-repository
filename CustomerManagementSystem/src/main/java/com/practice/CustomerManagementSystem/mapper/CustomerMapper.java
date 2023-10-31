package com.practice.CustomerManagementSystem.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.CustomerManagementSystem.entity.Customer;

@Mapper
public interface CustomerMapper {
 
    // 全顧客を取得するUserMapper.xml
    public List<Customer> getAll();
}
