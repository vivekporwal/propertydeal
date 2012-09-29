package com.property.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.property.models.SpringRoles;

@Repository
@Transactional
public class SpringRolesDao {
	@Autowired
	public SessionFactory hbSF;
	
	public int springRoleForNewUser(SpringRoles sr) {
		Session hbSession = hbSF.getCurrentSession();
		
		
		
		hbSession.saveOrUpdate(sr);
		hbSession.flush();
		return 1;
	}

}