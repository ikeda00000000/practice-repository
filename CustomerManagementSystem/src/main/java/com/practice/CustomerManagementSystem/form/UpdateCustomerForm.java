package com.practice.CustomerManagementSystem.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateCustomerForm{
	
	@NotBlank
	@Pattern(regexp="^([ぁ-んァ-ヶｱ-ﾝﾞﾟ一-龠]{2,20})?$")
	//varchar(20) 2~20、漢字かなカタカナ 
	
	private String customerName;
	
	// フォームからは0・1を送るためint型
	private int individual;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	private Date birth;
	
	@NotBlank
	@Pattern(regexp="^([0-9]{7})?$")
	//char(7)ハイフンなしで半角数字7桁
	private String zip;
	
	@NotBlank
	@Size(min=2, max=150)
	@Pattern(regexp="^([ぁ-んァ-ヶｱ-ﾝﾞﾟ一-龠0-9-])*")
	//varchar(150)2文字以上～150文字、漢字ひらカナ半角数字、記号はーだけ？
	private String address;
	
	// nullでもOK、varchar(11)ハイフンなしの半角数字11桁
	@Pattern(regexp="^([0-9]{11})?$")
	private String tel;
	
	// nullでもOK、varchar(255)
	@Email
	private String mail;
	
	//int(11)
	private int accountId;
	
	// 削除用
	private int isdeleted;
	
}