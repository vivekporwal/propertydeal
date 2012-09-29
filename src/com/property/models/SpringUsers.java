package com.property.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPRING_USERS")
public class SpringUsers {
	private long user_id;
	private String username;
	private String password;
	private int enabled;
	
	public SpringUsers() {
		this.user_id=0;
		this.username="";
		this.password="";
		this.enabled=1;
	}
	@Id	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "SpringUsers [user_id=" + user_id + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled + "]";
	}

}
