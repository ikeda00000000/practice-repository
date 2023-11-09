package com.practice.CustomerManagementSystem.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.CustomerManagementSystem.entity.Customer;

@Mapper
public interface CustomerMapper {
 
    // 全顧客を取得する
    public List<Customer> getAll();
    
    // キーワード検索の文字列を引数で受け取り、部分一致する顧客を取得する
    public List<Customer> findByKeyword(String keyword);
    
    // 新規登録
    public int create(Customer customer);
    
}
