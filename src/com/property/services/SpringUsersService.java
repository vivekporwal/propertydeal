package com.property.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.SpringUsersDao;
import com.property.models.SpringUsers;

@Service
public class SpringUsersService {
	
	@Autowired
	SpringUsersDao usersDao;
	
	public int entryOfNewUser(SpringUsers su) 
	{
		return usersDao.createNewUser(su);
	}
	
	public List<SpringUsers> getCredentials(String name)
	{
		return usersDao.getPassword(name);
	}
	public List<SpringUsers> getAllUsers()
	{
		return usersDao.getAllUsers();
	}
	public int enableOrDisableUser(long uid,int i) {
		usersDao.enableOrDisableUser(uid, i);
		return 1;
	}
	
	
}
