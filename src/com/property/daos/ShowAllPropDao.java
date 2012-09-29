package com.property.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.property.models.PostProperty;
import com.property.models.Search;

@Repository
@Transactional
public class ShowAllPropDao 
{
	
	@Autowired
	public SessionFactory hbSF;
	
	//Show All Property for Admin Specific
	public List<PostProperty> showAllPropDao()
	{
		Session hbSession = hbSF.getCurrentSession();
		
		Query query = hbSession.createQuery("from PostProperty pp");	
		
		List<PostProperty> prop_list = query.list();
		
		return prop_list ;
	}
	
	//Property Posted UserDomain Specific
	public List<PostProperty> showAllUserPropDao(String emailid)
	{
		Session hbSession = hbSF.getCurrentSession();
		
		Query query = hbSession.createQuery("from PostProperty pp where email_id=?");	
		query.setString(0, emailid);
		List<PostProperty> prop_list = query.list();
		
		return prop_list ;
	}

	public int updateProp(PostProperty prop)
	{
		Session hbSession = hbSF.getCurrentSession();		
		long pid = prop.getProperty_id() ;
		PostProperty p =(PostProperty)hbSession.get(PostProperty.class, pid) ;
		System.out.println(pid+"  ");
		System.out.println(p);
		p.setArea(prop.getArea()) ;
		p.setBhk(prop.getBhk()) ;
		p.setCity(prop.getCity()) ;
		p.setDescription(prop.getDescription()) ;
		p.setEmail_id(prop.getEmail_id()) ;
		p.setFurnished(prop.getFurnished()) ;
		p.setNegotiation_status(prop.getNegotiation_status()) ;
		p.setPossession(prop.getPossession()) ;
		p.setProperty_for(prop.getProperty_for()) ;
		p.setProperty_type(prop.getProperty_type()) ;
		hbSession.update(p);
		hbSession.flush();
		
		return 1 ;
	}
	
	public PostProperty getProperty(long id)
	{
		Session hbSession = hbSF.getCurrentSession();		
		PostProperty pp = (PostProperty)hbSession.get(PostProperty.class, id) ;		
		return pp ;
	}
}
