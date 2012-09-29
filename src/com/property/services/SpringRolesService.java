package com.property.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.property.daos.RegDao;
import com.property.daos.SpringRolesDao;
import com.property.models.SpringRoles;


@Service
public class SpringRolesService {

	@Autowired
    SpringRolesDao rolesDao;
	
	public int roleForNewUser(SpringRoles role) {
		return rolesDao.springRoleForNewUser(role);
	}
}