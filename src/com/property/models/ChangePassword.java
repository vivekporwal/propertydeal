package com.property.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePassword 
{
	@NotEmpty
	private String currentpassword;
	@NotEmpty
	@Size(min = 5, max = 15)
	private String newpassword;
	@NotEmpty
	@Size(min = 5, max = 15)
	private String confirmpassword;
	private String emailid;
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getCurrentpassword() 
	{
		return currentpassword;
	}
	
	public void setCurrentpassword(String currentpassword) 
	{
		this.currentpassword = currentpassword;
	}
	
	public String getNewpassword() 
	{
		return newpassword;
	}
	
	public void setNewpassword(String newpassword) 
	{
		this.newpassword = newpassword;
	}
	
	public String getConfirmpassword() 
	{
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) 
	{
		this.confirmpassword = confirmpassword;
	}

}
