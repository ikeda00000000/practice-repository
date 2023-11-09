package com.practice.CustomerManagementSystem.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Customer{
	//ID
	private int customerId;
	
	//顧客名
	private String customerName;
	
	//個人or法人
	private boolean individual;
	
	//生年月日
	private String birth;
	
	//郵便番号
	private String zip;
	
	//住所
	private String address;
	
	// 電話番号
	private String tel;
	
	// メールアドレス
	private String mail;
	
    // 不要と思ったけどフォームからの値を入れるときに使う？ 
	private int accountId;
	
	// 担当者についてはAccount型クラスをメンバー変数に持つ
	private Account account;
	
	// 削除フラグ
	private boolean isDeleted;
	
}