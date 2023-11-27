package com.practice.CustomerManagementSystem.service.login;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.CustomerManagementSystem.entity.Account;
import com.practice.CustomerManagementSystem.entity.User;
import com.practice.CustomerManagementSystem.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

/*
 * SpringBootで使うユーザ情報の取得を行うクラス
 * SpringBootv3系ではUserDetailsServiceを実装したクラスを、DIコンテナに保存すると
 * （@Controller,@Service,@Componentを自作クラスにつけるとか@Beanをつけたメソッドの戻り値にするとか）、
 * 自動的にそのインスタンスを使ってログイン処理を行ってくれる
 */
@RequiredArgsConstructor
@Service

public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserMapper userMapper;
	/*
	 * ユーザ情報を取得する
	 * もし引数のユーザ情報が存在しなかったらUsernameNotFoundExceptionを投げる
	 */

	@Override
	// 戻り値はUserDetails型
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//入力されたusenameに一致するAccountクラスを返す
		Account account = this.userMapper.findByName(username);
		
		// ユーザが見つからなかった場合、例外を投げる。→うまくこのメッセージ使えてない気がする
		if (account == null) {
			throw new UsernameNotFoundException("User[" + username + "] not found.");
		}
		
		return createUser(account);
	}

	/*
	 * DBから取得したユーザ情報をSpringBootのユーザ情報に入れ替える
	 * @param account DBから取得したユーザー情報
	 * @return SpringBootのユーザー情報
	 */
	private UserDetails createUser(Account account) {
		Set<GrantedAuthority> auth = new HashSet<>();
		// ロールにはROLE_というプレフィックスをつける
		auth.add(new SimpleGrantedAuthority("ROLE_" + account.getRole()));
		
		// DBから取得したaccountの情報を、User型（UserDetailsを実装したクラス）に詰め替える
		User userDetails = new User(account, auth);
		userDetails.setUsername(account.getUsername());
		userDetails.setPassword(account.getPassword());
		
		return userDetails;
	}

}
