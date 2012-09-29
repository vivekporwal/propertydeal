package com.property.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.property.models.PostProperty;
import com.property.models.PostRequirement;

@Repository
@Transactional
public class DeleteDao {

	@Autowired
	public SessionFactory hbSF;
	
	public int removeProperty(long propertyid)
	{
		Session hbSession = hbSF.getCurrentSession();
		PostProperty p = (PostProperty)hbSession.get(PostProperty.class,propertyid);
		hbSession.delete(p);
		return 1;
	}
	public int removeRequirement(long requirementid)
	{
		Session hbSession = hbSF.getCurrentSession();
		PostRequirement r = (PostRequirement)hbSession.get(PostRequirement.class,requirementid);
		hbSession.delete(r);
		return 1;
	}
	
}
