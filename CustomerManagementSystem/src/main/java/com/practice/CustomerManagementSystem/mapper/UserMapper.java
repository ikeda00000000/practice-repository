package com.practice.CustomerManagementSystem.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.CustomerManagementSystem.entity.Account;

@Mapper
public interface UserMapper {
 
    /**
     * 名前でユーザを検索。
     * 命名規則に従ってインタフェースでメソッドを定義すると、
     * JPAが実装を行ってくれる。
     * @param name 検索するユーザ名
     * @return ユーザ名に対応するユーザ
     */
    Account findByName(String name);
    
    List<Account> findAll();
    
    
}
