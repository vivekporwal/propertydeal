package com.property.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.daos.SearchDao;
import com.property.models.PostProperty;
import com.property.models.Search;

@Service
public class SearchService 
{
	@Autowired
	SearchDao search_dao ;
	
	public List<PostProperty> searchProperty(Search srch)
	{
		return search_dao.searchProp(srch) ;
	}
}
