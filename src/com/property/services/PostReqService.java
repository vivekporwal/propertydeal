package com.property.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.PostReqDao;
import com.property.models.PostRequirement;

@Service
public class PostReqService {
	
	@Autowired
	PostReqDao prDao;
	
	public int newReq(PostRequirement pr) {
		return prDao.newReq(pr);
	}
	

}
