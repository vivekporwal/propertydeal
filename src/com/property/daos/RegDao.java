package com.property.daos;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.property.models.Register;

@Repository
@Transactional
public class RegDao {
	@Autowired
	public SessionFactory hbSF;
	
	public int createNewUser(Register regUser) {
		Session hbSession = hbSF.getCurrentSession();
		Query query = hbSession.createSQLQuery("{ call register_proc(?,?,?,?,?,?,?,?)}");
		
		query.setString(0, regUser.getEmail_id());
		query.setString(1, regUser.getUser_type());
		query.setString(2, regUser.getFirst_name());
		query.setString(3, regUser.getLast_name());
		query.setString(4, regUser.getPassword());
		query.setString(5, regUser.getCity());
		query.setBigInteger(6, regUser.getMb_no());
		query.setString(7,regUser.getUser_type());
		int cnt = query.executeUpdate();
		return 1;
	}

	public List<Register> userDetails(String emailid)
	{
		Session hbSession = hbSF.getCurrentSession();
		Query q = hbSession.createQuery("from Register r where email_id = ?");
		q.setString(0, emailid);
		List<Register> userList = (List<Register>)q.list();
		return userList;
	}
	
	public int editDetails(Register reg)
	{
		Session hbSession = hbSF.getCurrentSession();
		Query query = hbSession.createSQLQuery("{ call SP_UPDATE_USERS_DETAIL(?,?,?,?,?)}");
		
		query.setString(0, reg.getEmail_id());
		query.setString(1, reg.getFirst_name());
		query.setString(2, reg.getLast_name());
		query.setString(3, reg.getCity());
		query.setBigInteger(4, reg.getMb_no());
		int cnt = query.executeUpdate();
		return 1;
	}
}



