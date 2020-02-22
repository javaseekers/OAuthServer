package com.khatri.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class RoleEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq",allocationSize = 1, sequenceName = "role_seq")
	private int roleId;
	
	@Column(name = "ROLE_NAME")
	private String roleName;

	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
