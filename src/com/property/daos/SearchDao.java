package com.property.daos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.property.models.PostProperty;
import com.property.models.Register;
import com.property.models.Search;

@Repository
@Transactional
public class SearchDao 
{
	@Autowired
	public SessionFactory hbSF;
	
	public List<PostProperty> searchProp(Search srch)
	{
		
		List<PostProperty> propList = new ArrayList<PostProperty>();
		
		Session hbSession = hbSF.getCurrentSession();
		
		Query email_query = hbSession.createQuery("select r.email_id from Register r where r.user_type=?");
		Query prop_query = hbSession.createQuery("from PostProperty pp where email_id=? and property_for=? and property_type=? and city=? and total_price between ? and ?");
				
		String[] postedby = srch.getPosted_by();
		for(String pby : postedby)
		{
			if(pby.equals("owner"))
			{
				email_query.setString(0, "ROLE_INDIVIDUAL") ;
			}
			if(pby.equals("broker"))
			{
				email_query.setString(0, "ROLE_BROKER") ;
			}
			if(pby.equals("builder"))
			{
				email_query.setString(0, "ROLE_BUILDER") ;
			}
			
		}
		List<String> emailids = email_query.list();	
		
		prop_query.setString(1, srch.getProperty_for()) ;
		prop_query.setString(2, srch.getType()) ;
		prop_query.setString(3, srch.getCity()) ;
		prop_query.setLong(4, Long.parseLong(srch.getMinbudget())) ;
		prop_query.setLong(5, Long.parseLong(srch.getMaxbudget())) ;
		
		for(String emailid : emailids)
		{		
			prop_query.setString(0, emailid) ;
		
			List<PostProperty> prop = prop_query.list();
			for(PostProperty p : prop)
			{
				propList.add(p);		
			}
		}
		
		return propList ;
	}
}
