package com.property.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPRING_ROLES")
public class SpringRoles {
	 
	 private int user_role_id;
	 private int user_id;
	 private String authority;
	 
	 public SpringRoles()
	 {
		 this.user_role_id=0;
		 this.user_id=0;
		 this.authority="";
	 }
	@Id
	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	 
	 
}
