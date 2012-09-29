package com.property.models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import sun.security.util.BigInt;

@Entity
@Table(name="USERS_DETAIL")
public class Register {	    
	private String email_id;
	private String user_type;
	@NotEmpty
	private String first_name;
	private String last_name;
	private String password;
	private String city;
	private BigInteger mb_no;
	
	
	public Register() {
		this.email_id = "";
		this.user_type="";
		this.first_name="";
		this.last_name="";
		this.city="";
		this.mb_no=new BigInteger("9876543210");
	}

	@Id
	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getUser_type() {
		return user_type;
	}


	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	

	public BigInteger getMb_no() {
		return mb_no;
	}

	public void setMb_no(BigInteger mb_no) {
		this.mb_no = mb_no;
	}

	@Override
	public String toString() 
	{
		return "Register [email_id=" + email_id + ", user_type=" + user_type
				+ ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", city=" + city + ", mb_no="
				+ mb_no + "]";
	}

	
	
	
}
