package com.khatri.model;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	public CustomUser(UserEntity2 user) {
		super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
	}
}
