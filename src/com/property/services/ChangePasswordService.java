package com.property.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.ChangePasswordDao;
import com.property.models.ChangePassword;

@Service
public class ChangePasswordService 
{
	@Autowired
	ChangePasswordDao change_pswd_dao;
	
	public int modifyPassword(ChangePassword pswd)
	{
		return change_pswd_dao.changePassword(pswd);
	}
}
