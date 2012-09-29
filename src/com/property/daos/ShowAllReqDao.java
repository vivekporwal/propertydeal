package com.property.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.property.models.PostProperty;
import com.property.models.PostRequirement;
import com.property.models.Search;

@Repository
@Transactional
public class ShowAllReqDao 
{
	
	@Autowired
	public SessionFactory hbSF;
	
	public List<PostRequirement> showAllReqDao()
	{
		Session hbSession = hbSF.getCurrentSession();
			
		Query query = hbSession.createQuery("from PostRequirement pr");	
				
		List<PostRequirement> req_list = query.list();
		
		return req_list ;
	}

	//Requirements Posted UserDomain Specific
	public List<PostRequirement> showAllUserReqDao(String emailid)
	{
		Session hbSession = hbSF.getCurrentSession();
		
		Query query = hbSession.createQuery("from PostRequirement pp where email_id=?");	
		query.setString(0, emailid);
		List<PostRequirement> req_list = query.list();
		
		return req_list ;
	}
	
	public PostRequirement getReq(long id)
	{
		Session hbSession = hbSF.getCurrentSession();		
		PostRequirement rr = (PostRequirement)hbSession.get(PostRequirement.class, id) ;		
		return rr ;
	}
	
	public int updateReq(PostRequirement req)
	{
		Session hbSession = hbSF.getCurrentSession();		
		long req_id = req.getRequirement_id() ;
		PostRequirement requirement =(PostRequirement)hbSession.get(PostRequirement.class, req_id);
		
		requirement.setArea(req.getArea()) ;
		requirement.setBhk(req.getBhk()) ;
		requirement.setCity(req.getCity()) ;
		requirement.setEmail_id(req.getEmail_id()) ;
		requirement.setMaxbudget(req.getMaxbudget()) ;
		requirement.setMinbudget(req.getMinbudget()) ;
		requirement.setProperty_type(req.getProperty_type()) ;
		requirement.setRequirement_for(req.getRequirement_for());
		return 1 ;
	}
}
