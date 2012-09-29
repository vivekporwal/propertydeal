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


@Repository
@Transactional
public class PostPropDao {
	@Autowired
	public SessionFactory hbSF;
	
	public int newProp(PostProperty pp) {
		Session hbSession = hbSF.getCurrentSession();
		 
		Query q = hbSession.createSQLQuery("{ call property_proc(?,?,?,?,?,?,?,?,?,?,?,?)}");
		q.setString(0, pp.getEmail_id());
		q.setString(1, pp.getProperty_for());
		q.setString(2, pp.getProperty_type());
		q.setString(3, pp.getTransaction());
		q.setString(4, pp.getCity());
		q.setString(5, pp.getBhk());
		q.setString(6, pp.getFurnished());
		q.setDouble(7, pp.getArea());
		q.setDouble(8, pp.getTotalprice());
		q.setString(9, pp.getNegotiation_status());
		q.setString(10, pp.getDescription());
		q.setString(11, pp.getPossession());
		int cnt = q.executeUpdate();
		return 1;
	}
	public List<PostProperty> getProperty(PostRequirement pr)
	{
		String property_for;
		Session hbSession = hbSF.getCurrentSession();
		if(pr.getRequirement_for() == "Buy")
		{
			property_for = "sell";
		}
		else
		{
			property_for = "rent";
		}
		
		Query q = hbSession.createQuery("from PostProperty p where p.property_type = ? and p.property_for = ? and p.city = ?");
		q.setString(0,pr.getProperty_type());
		q.setString(1, property_for);
		q.setString(2, pr.getCity());
		return q.list();
	}
	
	

}
