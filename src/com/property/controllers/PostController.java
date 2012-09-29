package com.property.controllers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.property.models.PostProperty;
import com.property.models.PostRequirement;
import com.property.services.MailForm;
import com.property.services.PostPropService;
import com.property.services.PostReqService;
import com.property.services.SendForm;



@RequestMapping("/post")
@Controller
public class PostController  {
	@Autowired
	PostPropService ppsrv;
	
	@Autowired
	PostReqService prsrv;
	
	//sending the model of PostProperty
	@RequestMapping("/property")
	public ModelAndView postProperty(ModelMap m) 
	{
		PostProperty prop = new PostProperty();
		m.addAttribute("property", prop);
		
		prop.setProperty_for("sell");
		prop.setTransaction("old");
		prop.setPossession("underconstruction");
		
		Map<String,String>residential = new TreeMap<String, String>();
		
		residential.put("residential_plot", "Residential Plot") ;
		residential.put("residential_house", "Residential House") ;
		residential.put("multistory_aptmt", "Multistory Apartment");
		residential.put("villa", "Villa") ;
		m.addAttribute("res", residential);
		
		Map<String,String>commercial = new TreeMap<String, String>();
		commercial.put("builder_floor", "Builder Floor Apartment") ;
		commercial.put("commercial_land", "Commercial Land") ;
		commercial.put("shop", "Shop") ;
		commercial.put("office", "Office") ;
		commercial.put("showroom", "Showroom") ;
		commercial.put("hotel", "Hotel/Hotel Sites") ;
		commercial.put("guest_house", "Guest House");
		commercial.put("business_centre", "Business Centre") ;
		commercial.put("warehouse", "Warehouse/Godown");
		commercial.put("industrial", "Industries");
		m.addAttribute("comm", commercial);
		
		Map<String,String>agricultural = new TreeMap<String, String>();
		agricultural.put("agri_land", "Agricultural Land");
		agricultural.put("farm_house", "Farm House");
		m.addAttribute("agri", agricultural);
		
		Map<String, String> city = new TreeMap<String, String>();
		city.put("pune", "Pune");
		city.put("mumbai","Mumbai");
		city.put("delhi","Delhi");
		city.put("kolkata","Kolkata");
		city.put("bangalore", "Bangalore"); 
		m.addAttribute("city",city);
		
		TreeMap<String, Integer> bhk = new TreeMap<String, Integer>();
		bhk.put("one",1);
		bhk.put("two",2);
		bhk.put("three",3);
		bhk.put("four", 4);
		bhk.put("five", 5);
		bhk.put("six", 6);
		m.addAttribute("bhk",bhk);
		
		TreeMap<String, String> furnish = new TreeMap<String, String>();
		furnish.put("furnished", "Furnished");
		furnish.put("unfurnished","Unfurnished");
		furnish.put("semifurnished","Semifurnished");
		m.addAttribute("furnish",furnish);
		return new ModelAndView("postproperty","pp",prop);		

	}
	
	//sending the model of PostRequirement
	@RequestMapping("/requirement")
	public ModelAndView require(ModelMap m )
	{
		PostRequirement req = new PostRequirement();
		m.addAttribute("require", req);
		req.setRequirement_for("buy");
		
		Map<String,String>residential = new TreeMap<String, String>();
		
		residential.put("residential_plot", "Residential Plot") ;
		residential.put("residential_house", "Residential House") ;
		residential.put("multistory_aptmt", "Multistory Apartment");
		residential.put("villa", "Villa") ;
		m.addAttribute("res", residential);
		
		Map<String,String>commercial = new TreeMap<String, String>();
		commercial.put("builder_floor", "Builder Floor Apartment") ;
		commercial.put("commercial_land", "Commercial Land") ;
		commercial.put("shop", "Shop") ;
		commercial.put("office", "Office") ;
		commercial.put("showroom", "Showroom") ;
		commercial.put("hotel", "Hotel/Hotel Sites") ;
		commercial.put("guest_house", "Guest House");
		commercial.put("business_centre", "Business Centre") ;
		commercial.put("warehouse", "Warehouse/Godown");
		commercial.put("industrial", "Industries");
		m.addAttribute("comm", commercial);
		
		Map<String,String>agricultural = new TreeMap<String, String>();
		agricultural.put("agri_land", "Agricultural Land");
		agricultural.put("farm_house", "Farm House");
		m.addAttribute("agri", agricultural);
		
		Map<String, String> city = new TreeMap<String, String>();
		city.put("pune", "Pune");
		city.put("mumbai","Mumbai");
		city.put("delhi","Delhi");
		city.put("kolkata","Kolkata");
		city.put("bangalore", "Bangalore"); 
		m.addAttribute("city",city);
		
		TreeMap<String, Integer> bhk = new TreeMap<String, Integer>();
		bhk.put("one",1);
		bhk.put("two",2);
		bhk.put("three",3);
		bhk.put("four", 4);
		bhk.put("five", 5);
		bhk.put("six", 6);
		m.addAttribute("bhk",bhk);
		
		TreeMap<String, String> minbudget = new TreeMap<String, String>();
		minbudget.put("10000", "10000");
		minbudget.put("20000", "20000");
		minbudget.put("50000", "50000");
		minbudget.put("100000", "1lac");
		minbudget.put("500000", "5lacs");
		minbudget.put("1000000", "10lacs");
		minbudget.put("2000000", "20lacs");
		minbudget.put("5000000", "50lacs");
		minbudget.put("10000000", "1crore");
		minbudget.put("50000000", "5crore");
		m.addAttribute("minbudget",minbudget);
		
		TreeMap<String, String> maxbudget = new TreeMap<String, String>();
		maxbudget.put("10000", "10000") ;
		maxbudget.put("20000", "20000") ;
		maxbudget.put("50000", "50000") ;
		maxbudget.put("100000", "1lac") ;
		maxbudget.put("500000", "5lacs") ;
		maxbudget.put("1000000", "10lacs") ;
		maxbudget.put("2000000", "20lacs") ;
		maxbudget.put("5000000", "50lacs") ;
		maxbudget.put("10000000", "1crore") ;
		maxbudget.put("50000000", "5crore") ;
		m.addAttribute("maxbudget", maxbudget);
		
		return new ModelAndView("postrequirement","pr",req);
	}
	
	// Handle the request after PostProperty page is submitted 
	@RequestMapping("/propertyposted")
	public ModelAndView postProperty(@ModelAttribute("pp") PostProperty pp,HttpSession session) {
		
		if(	pp.getNegotiation_status() == null)
			pp.setNegotiation_status("no");	
		else
			pp.setNegotiation_status("yes");
		String uname = (String)session.getAttribute("uname");
		pp.setEmail_id(uname);
		System.out.println(uname);
		System.out.println("negotiation = " + pp.getNegotiation_status());
		
		ppsrv.newProp(pp);
		return new ModelAndView("propertyposted");		

	}
	
	//Handle the request after PostRequirement page is submitted 
	@RequestMapping("/requirementposted")
	public ModelAndView postRequirement(@ModelAttribute("pr") PostRequirement pr,HttpSession session) {
		String uname = (String)session.getAttribute("uname");
		pr.setEmail_id(uname);
		System.out.println(uname);
		int cnt = prsrv.newReq(pr);
		if (cnt == 1)
		{
			List<PostProperty> proplist =  ppsrv.getProperty(pr);
			StringBuffer msg = new StringBuffer();
			for (PostProperty postProperty : proplist) 
			{
				msg.append(postProperty.toString()+"\r\n");
				System.out.println(postProperty.toString());
			}		
			String message = msg.toString() ;
			SendForm send = new SendForm();
			MailForm form = new MailForm();
			form.setTo(uname);
			form.setMessage(message);
			form.setFrom("pushpak_bittu@sify.com");			
			
			send.sendMail(form);
		}
		return new ModelAndView("requirementposted");		

	}	

	
	
	
}
