package com.practice.CustomerManagementSystem.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// SpringSecurityの設定用のクラスであることをSpringに伝える
@Configuration
//Spring Securityを使うための設定
@EnableWebSecurity
public class WebSecurityConfig {
	
	// 基本的な設定をここで行う
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		// 認証と認可に関する設定
		.authorizeHttpRequests(
		// /login/indexはアクセス制限かけない
				(requests) -> requests.requestMatchers("/login/**").permitAll()
		// /adminはADMINロールをもつユーザのみアクセス可能
		// TODO 必要に応じて/admin/*
		.requestMatchers("/admin").hasRole("ADMIN")
		// /userはUSERロールを持つユーザのみアクセス可能
		// TODO 必要に応じて/user/**（複数階層）
		.requestMatchers("/user").hasRole("USER")
		// それ以外のページは認証が必要
		.anyRequest().authenticated()
	   ).formLogin((form) -> form
		// ログインを実行するページを指定。次のログインページのformがこのURLにPOST?するとログイン認証の処理が開始される
		.loginProcessingUrl("/login/index")
		// 実際のログイン画面のURL
		.loginPage("/login/index")
		// ログインに失敗した時の遷移先
		.failureUrl("/login/index")
		// ユーザIDとパスワードのname設定
		.usernameParameter("username")
		.passwordParameter("password")
		// ログイン成功時の遷移先
		.defaultSuccessUrl("/common", true)
	   ).logout((form) -> form
		// ログアウト処理を行うページ指定、ここにPOSTするとログアウト
		.logoutUrl("/logout")
		// ログアウトした時の遷移先
		.logoutSuccessUrl("/login/index")
		);
		return http.build();
	}
	
	
	/*
	 *  パスワードのハッシュ化を行うアルゴリズムを返す
	 *  @Beanをつけたメソッドで、PasswordEncoderを実装したクラスのインスタンスを返すと、
	 *  SpringBootが自動的にパスワードのハッシュ化を行ってくれる。
	 *  @Beanは、これを付けたメソッドの戻り値をDIコンテナの保存してくれる。
	 *  するとDIしている他のコンテナで自動的に利用可能になる。
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}

