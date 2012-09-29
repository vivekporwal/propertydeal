package com.property.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.property.daos.RegDao;
import com.property.models.Register;

@Service
public class RegisterService {

	@Autowired
	RegDao registerDao;
	
	public int registerNewUser(Register regUser) 
	{
		return registerDao.createNewUser(regUser);
	}
	
	public List<Register> userDetails(String emailid)
	{
		List<Register> userList = registerDao.userDetails(emailid);
		return userList;
	}
	
	public int editProfile(Register reg)
	{
		return registerDao.editDetails(reg);
	}
}
