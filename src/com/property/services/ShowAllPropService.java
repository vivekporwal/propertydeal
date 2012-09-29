package com.property.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.ShowAllPropDao;
import com.property.models.PostProperty;

@Service
public class ShowAllPropService {
	
	@Autowired
	ShowAllPropDao propDao;

	public List<PostProperty> showAllProp()
	{
		List<PostProperty> prop_list = propDao.showAllPropDao();
		
		return prop_list;
	}
	
	public List<PostProperty> showAllUserProp(String emailid)
	{
		List<PostProperty> prop_list = propDao.showAllUserPropDao(emailid);
		
		return prop_list;
	}

	public int upadteProp(PostProperty prop)
	{
		return propDao.updateProp(prop) ;
	}
	
	public PostProperty getProp(long id)
	{
		return propDao.getProperty(id) ;
	}
}
