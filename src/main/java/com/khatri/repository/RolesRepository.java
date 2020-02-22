package com.khatri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khatri.model.RoleEntity;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, Integer>
{
	public RoleEntity getByRoleName(String roleName);
}
