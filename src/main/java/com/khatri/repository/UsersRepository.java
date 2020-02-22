package com.khatri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khatri.model.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

	public UsersEntity getByEmail(String email);

	public UsersEntity getUserByEmail(String email);

	public UsersEntity getByIsActive(boolean isActive);

}
