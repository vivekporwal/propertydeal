package com.property.controllers;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.property.models.PostProperty;
import com.property.models.PostRequirement;
import com.property.services.ShowAllPropService;
import com.property.services.ShowAllReqService;


@RequestMapping("/update")
@Controller
public class UpdateController 
{
	@Autowired
	ShowAllPropService showpropsvc ;
	
	@Autowired
	ShowAllReqService showreqsvc;
	
	@RequestMapping("/updatepp")
	public ModelAndView updateLink(ModelMap m ,HttpServletRequest request , HttpServletResponse response , HttpSession session) 
	{
		if(request.getParameter("propid")!=null)
		{
			long pid = Long.parseLong(request.getParameter("propid"));
	
			session.setAttribute("pid", pid) ;
			
			PostProperty pp1 =  showpropsvc.getProp(pid) ;						 				
			m.addAttribute("property", pp1);
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
			m.addAttribute("city1",city);
			
			TreeMap<String, Integer> bhk = new TreeMap<String, Integer>();
			bhk.put("one",1);
			bhk.put("two",2);
			bhk.put("three",3);
			bhk.put("four", 4);
			bhk.put("five", 5);
			bhk.put("six", 6);
			m.addAttribute("bhk1",bhk);
			
			TreeMap<String, String> furnish = new TreeMap<String, String>();
			furnish.put("furnished", "Furnished");
			furnish.put("unfurnished","Unfurnished");
			furnish.put("semifurnished","Semifurnished");
			m.addAttribute("furnish",furnish);
			return new ModelAndView("updateproperty" ,"pp1" , pp1) ;	
		}
		String userhome = (String)session.getAttribute("userhomepage");
		
		return new ModelAndView("redirect:"+userhome);
	
	}
		
	@RequestMapping("/updateprop")
	public ModelAndView updateProperty(@ModelAttribute("updt") PostProperty pp , HttpSession session)
	{
		String uname = (String)session.getAttribute("uname");
		long pid = (long)session.getAttribute("pid") ;
		
		pp.setProperty_id(pid) ;
		pp.setEmail_id(uname) ;
		if(	pp.getNegotiation_status() == null)
			pp.setNegotiation_status("no");	
		else
			pp.setNegotiation_status("yes");
		
		int i = showpropsvc.upadteProp(pp) ;
		
		return new ModelAndView("updatedprop") ;
	}
	
	
	@RequestMapping("/updaterr")
	public ModelAndView updateReq(ModelMap m ,HttpServletRequest request , HttpServletResponse response , HttpSession session)
	{
		long reqid = Long.parseLong(request.getParameter("reqid"));
		session.setAttribute("reqid", reqid) ;
		PostRequirement pr1 = showreqsvc.getReq(reqid) ;
		m.addAttribute("requirement", pr1) ;
		
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
		
		return new ModelAndView("updaterequirement","updatereq", pr1 ) ;		
	}
	
	@RequestMapping("/updatereq")
	public ModelAndView updatedRequirement(@ModelAttribute("updatereq") PostRequirement req , HttpSession session)
	{
		String uname = (String)session.getAttribute("uname");
		long reqid = (long)session.getAttribute("reqid");
		
		req.setRequirement_id(reqid);
		req.setEmail_id(uname);		
		showreqsvc.upadteReq(req);				
		return new ModelAndView("updatedreq");
		
	}
	
	
}
