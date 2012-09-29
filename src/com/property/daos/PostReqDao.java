package com.property.daos;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.property.models.PostProperty;
import com.property.models.PostRequirement;

@Repository
@Transactional
public class PostReqDao {
	@Autowired
	public SessionFactory hbSF;
	
	public int newReq(PostRequirement pr) {
		Session hbSession = hbSF.getCurrentSession();
		 
		Query q = hbSession.createSQLQuery("{ call requirement_proc(?,?,?,?,?,?,?,?)}");
		q.setString(0, pr.getEmail_id());
		q.setString(1, pr.getRequirement_for());
		q.setString(2, pr.getProperty_type());
		q.setString(3, pr.getCity());
		q.setString(4, pr.getBhk());
		q.setDouble(5, pr.getArea());
		q.setString(6, pr.getMinbudget());
		q.setString(7, pr.getMaxbudget());
		
		int cnt = q.executeUpdate();
		return 1;
	}
}