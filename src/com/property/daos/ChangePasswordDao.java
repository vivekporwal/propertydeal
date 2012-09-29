package com.property.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.property.models.ChangePassword;

@Repository
@Transactional
public class ChangePasswordDao 
{
	@Autowired
	public SessionFactory hbSF;
	
	public int changePassword(ChangePassword pswd)
	{
		
		Session hbSession = hbSF.getCurrentSession();
		Query  q =hbSession.createSQLQuery("{ call sp_changepswd(?,?)}");
		q.setString(0, pswd.getEmailid());
		q.setString(1, pswd.getNewpassword());
		int cnt = q.executeUpdate();
		hbSession.flush();
		return cnt;
	}
}
