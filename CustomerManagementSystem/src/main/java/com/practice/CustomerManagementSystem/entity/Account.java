package com.practice.CustomerManagementSystem.entity;

import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
public class Account {

	@UUID
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String role;
	
	@NotNull
	private boolean isEnabled;
}
