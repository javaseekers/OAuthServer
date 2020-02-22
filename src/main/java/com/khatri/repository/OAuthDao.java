package com.khatri.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.khatri.model.UserEntity2;
import com.khatri.model.UsersEntity;

@Repository
public class OAuthDao {
	
	@Autowired
	private UsersRepository repo;

	public UserEntity2 getUserDetails(String username) {
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		
		UsersEntity user = repo.getByEmail(username);
		UserEntity2 userEntity = new UserEntity2();
		if(user!=null) {
			userEntity.setUsername(user.getEmail());
			userEntity.setPassword(user.getPassword());
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRoleEntity().getRoleName());
			grantedAuthoritiesList.add(grantedAuthority);
			userEntity.setGrantedAuthoritiesList(grantedAuthoritiesList);
			return userEntity;
		}
		return null;
	}
}
