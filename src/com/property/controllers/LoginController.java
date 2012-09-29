package com.property.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



import com.property.models.ChangePassword;
import com.property.models.PostProperty;
import com.property.models.Register;
import com.property.models.Search;
import com.property.services.ChangePasswordService;
import com.property.services.RegisterService;
import com.property.services.SearchService;

@Controller
public class LoginController {
	
	@Autowired
	SearchService ssrv;
	
	@Autowired
	ChangePasswordService chpswdsrv;
	
	@RequestMapping("/login")
	public String login() {		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping("/roleprovider")
	public String roleProvider(HttpSession session)
	{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String role = user.getAuthorities().toString();
		
		
		session.setAttribute("uname", user.getUsername());
		session.setAttribute("role", role);		
		
		System.out.println("username="+user.getUsername());
		System.out.println("userrole="+role);
		
		String url = null;
		if(role.equals("[ROLE_ADMIN]"))
		{			
			url = "redirect:/admin/homepage";	
		}
		
		if(role.equals("[ROLE_INDIVIDUAL]"))
		{
			
			url = "redirect:/individual/homepage";
		}
		
		if(role.equals("[ROLE_BROKER]"))
		{
			url = "redirect:/broker/homepage";
			
		}
		
		if(role.equals("[ROLE_BUILDER]"))
		{
			url = "redirect:/builder/homepage";
			
		}
		
		return url ;
	}
	
	@RequestMapping("/changepassword")
	public ModelAndView changepswd()
	{
		ChangePassword chgpswd = new ChangePassword();
		
		return new ModelAndView("changepassword","chgpswd",chgpswd);
	}
	
	@RequestMapping("/modifypassword")
	public String modifypswd(@ModelAttribute ("chgpswd") ChangePassword chgpswd,HttpSession session)
	{
		String emailid = (String) session.getAttribute("uname");
		chgpswd.setEmailid(emailid);
		int cnt = chpswdsrv.modifyPassword(chgpswd);
		return "passwordchanged";
	}
	
	
	@RequestMapping("/search")
	public ModelAndView search( ModelMap m ,HttpSession session)
	{
		Search srch = new Search();
		srch.setProperty_for("sell");
		String[] postedby = {"owner","broker","builder"};
		srch.setPosted_by(postedby);
		m.addAttribute("search",srch);
		
		Map<String, String>residential = new TreeMap<String, String>() ;
		Map<String, String>commercial = new TreeMap<String, String>() ;
		Map<String, String>agricultural = new TreeMap<String, String>() ;
		Map<String, String>city = new TreeMap<String, String>() ;
		TreeMap<String, Integer> bhk = new TreeMap<String, Integer>();
		
		residential.put("residential_plot", "Residential Plot") ;
		residential.put("residential_house", "Residential House") ;
		residential.put("multistory_aptmt", "Multistory Apartment");
		residential.put("villa", "Villa") ;
		
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
		
		agricultural.put("agri_land", "Agricultural Land");
		agricultural.put("farm_house", "Farm House");
		
		city.put("mumbai", "Mumbai") ;
		city.put("delhi", "Delhi") ;
		city.put("bangalore", "Banglore") ;
		city.put("kolkata" , "Kolkata") ;
		city.put("pune", "Pune") ;
		city.put("chandigarh", "Chandigarh") ;		
		
		bhk.put("one",1);
		bhk.put("two",2);
		bhk.put("three",3);
		bhk.put("four", 4);
		bhk.put("five", 5);
		bhk.put("six", 6);
		
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
		m.addAttribute("bhk",bhk);
		m.addAttribute("commercial", commercial) ;
		m.addAttribute("residential", residential) ;
		m.addAttribute("agricultural", agricultural) ;
		m.addAttribute("city", city) ;
		String searchpage = (String)session.getAttribute("usersearch");
		
		return new ModelAndView("search","search",srch);
	}
	@RequestMapping("/searchedprops")
	public ModelAndView searchedProps(@ModelAttribute("search") Search search,HttpSession session)
	{
		String[] postedby = search.getPosted_by();
		
		System.out.println("property search start");
		List<PostProperty> searchedprop = ssrv.searchProperty(search);
		
		System.out.println("searched Properties......");
		for(PostProperty property : searchedprop)
		{
			System.out.println(property);
		}
		
		System.out.println("property search end");
		return new ModelAndView("searchedprops","sp",searchedprop);
	}
	
	@RequestMapping("/contacts")
	public String contacts()
	{
		return "contacts";
	}
	
	@RequestMapping("/details")
	public String deatils()
	{
		return "details";
	}
}