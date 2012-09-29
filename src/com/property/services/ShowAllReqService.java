package com.property.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.ShowAllReqDao;
import com.property.models.PostRequirement;

@Service
public class ShowAllReqService {
	
	@Autowired
	ShowAllReqDao reqDao;

	public List<PostRequirement> showAllReq()
	{
		List<PostRequirement> req_list = reqDao.showAllReqDao();
		
		return req_list;
	}
	
	public List<PostRequirement> showAllUserReq(String emailid)
	{
		List<PostRequirement> req_list = reqDao.showAllUserReqDao(emailid);
		
		return req_list;
	}
	
	public int upadteReq(PostRequirement prop)
	{
		return reqDao.updateReq(prop) ;
	}
	
	public PostRequirement getReq(long id)
	{
		return reqDao.getReq(id) ;
	}
}
