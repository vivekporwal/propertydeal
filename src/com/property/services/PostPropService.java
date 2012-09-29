package com.property.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.PostPropDao;
import com.property.models.PostProperty;
import com.property.models.PostRequirement;

@Service
public class PostPropService {

	@Autowired
	PostPropDao ppDao;
	
	public int newProp(PostProperty pp) 
	{
		return ppDao.newProp(pp);
	}
	public List<PostProperty> getProperty(PostRequirement req)
	{
		return ppDao.getProperty(req);
	}
	
	
}
