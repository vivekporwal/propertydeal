package com.property.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.property.daos.DeleteDao;

@Service
public class DeleteService {

	@Autowired
	DeleteDao delDao;
	
	public int deleteProp(long propertyid)
	{
		int cnt = delDao.removeProperty(propertyid);
		return cnt;
	}
	public int deleteReq(long requirementid)
	{
		int cnt = delDao.removeRequirement(requirementid);
		return cnt;
	}
	
}
