package com.practice.CustomerManagementSystem.entity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


//lambokが効かない？インターフェースでgetterがあるから？
public class User implements UserDetails {
	/*
	 * accountは宣言しただけで初期化してないnullなのに、
	 * setUsername()しようとしたからぬるぽ投げられる。
	 * そもそもここでセットしようとするのがよくないのでは？
	 */
	@Autowired
	private Account account;
	
	private Collection<GrantedAuthority> authorities;
	
	public User(Account account,  Collection<GrantedAuthority> authorities) {
		
//		account.setUsername(username);
//		account.setPassword(password);
		this.account = account;
		this.authorities = authorities;
		}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}
	
	public void setUsername(String username) {
		account.setUsername(username);
	}
	
	@Override
	public String getPassword() {
		return account.getPassword();
	}
	
	public void setPassword(String password) {
		account.setPassword(password);
	}
	
	public String getRole() {
		return account.getRole();
	}

	@Override
	public boolean isAccountNonExpired() {
		//　アカウントの有効期限切れチェック
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// アカウントのロックチェック
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 資格情報の有効期限切れチェック
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 有効なアカウントかをチェック
		return true;
	}

}
