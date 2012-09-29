package com.property.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.property.models.SpringUsers;

@Repository
@Transactional
public class SpringUsersDao {

	@Autowired
	public SessionFactory hbSF;
	
	public int createNewUser(SpringUsers user) {
		Session hbSession = hbSF.getCurrentSession();
		hbSession.saveOrUpdate(user);
		hbSession.flush();
		return 1;
	}
	
	public List<SpringUsers> getPassword(String name)
	{
		Session hbSession =	hbSF.getCurrentSession();
		Query q = hbSession.createQuery("from SpringUsers user where name = ?");
		q.setString(0, name);
		return q.list();
	}
	
	public List<SpringUsers> getAllUsers()
	{
		Session hbSession =	hbSF.getCurrentSession();
		Query q = hbSession.createQuery("from SpringUsers");
		return q.list();
	}
	public int enableOrDisableUser(long uid,int i) {
		Session hbSession = hbSF.getCurrentSession();
		SpringUsers user = (SpringUsers)hbSession.get(SpringUsers.class,uid);		
		user.setEnabled(i);
		hbSession.saveOrUpdate(user);
		return 1;
	}
	
}
