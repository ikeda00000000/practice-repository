package com.practice.CustomerManagementSystem.entity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Data
public class User implements UserDetails {
@Autowired
private Account account;

	private final Collection<GrantedAuthority> authorities;
	
	public User(String username, String password,  Collection<GrantedAuthority> authorities) {
		account.setUsername(username);
		account.setPassword(password);
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
	
	@Override
	public String getPassword() {
		return account.getPassword();
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
