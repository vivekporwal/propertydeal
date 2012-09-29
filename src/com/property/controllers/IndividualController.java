package com.property.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.property.models.PostProperty;
import com.property.models.PostRequirement;
import com.property.models.Register;
import com.property.models.Search;
import com.property.services.DeleteService;
import com.property.services.RegisterService;
import com.property.services.SearchService;
import com.property.services.ShowAllPropService;
import com.property.services.ShowAllReqService;

@RequestMapping("/individual")
@Controller
public class IndividualController 
{
	@Autowired
	ShowAllPropService allpropsrv;
	
	@Autowired
	ShowAllReqService allreqsrv;
	
	@Autowired
	SearchService ssrv;
	
	@Autowired
	DeleteService delsrv;
	
	@Autowired
	RegisterService regsvc;
	
	@RequestMapping("/homepage")
	public ModelAndView homepage(HttpSession session)
	{
		session.setAttribute("userhome", "/PropertyDeal/individual/homepage");
		session.setAttribute("userhomepage", "/individual/homepage");
		session.setAttribute("delprop", "/PropertyDeal/individual/deleteprop");
		session.setAttribute("delreq", "/PropertyDeal/individual/deletereq");
		session.setAttribute("editprofile", "/PropertyDeal/individual/profile");
		session.setAttribute("usersearch", "/PropertyDeal/individual/usersearch");
		session.setAttribute("usersearchedprops", "/PropertyDeal/individual/usersearchedprops");
		
		String emailid = (String) session.getAttribute("uname");
		List<Register> user = regsvc.userDetails(emailid);
		
		Register reg = new Register();
		
		for (Register register : user) 
		{		
			reg.setFirst_name(register.getFirst_name());
			reg.setLast_name(register.getLast_name());
			reg.setCity(register.getCity());
			reg.setMb_no(register.getMb_no());
			
		}
		return new ModelAndView("individualhomepage","user",reg);
	}
	
	@RequestMapping("/usersearch")
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
		
		return new ModelAndView("usersearch","search",srch);
	}
	@RequestMapping("/usersearchedprops")
	public ModelAndView searchedProps(@ModelAttribute("search") Search search,HttpSession session)
	{
		String[] postedby = search.getPosted_by();
		
		System.out.println("property search start");
		List<PostProperty> searchedprop = ssrv.searchProperty(search);
		return new ModelAndView("usersearchedprop","sp",searchedprop);
	}
	
	@RequestMapping("/profile")
	public ModelAndView profile(HttpSession session)
	{
		String emailid = (String) session.getAttribute("uname");
		List<Register> user = regsvc.userDetails(emailid);
		Register reg = new Register();
		for (Register register : user) 
		{		
			reg.setFirst_name(register.getFirst_name());
			reg.setLast_name(register.getLast_name());
			reg.setCity(register.getCity());
			reg.setMb_no(register.getMb_no());
		}
		return new ModelAndView("updateindividualprofile","user",reg);
		
	}
	
	
	@RequestMapping("/editprofile")
	public String editprofile(@ModelAttribute("user") Register reg,HttpSession session)
	{
		String emailid = (String) session.getAttribute("uname");
		reg.setEmail_id(emailid);
		regsvc.editProfile(reg);
		return "individualdetailsupdated";
	}

	@RequestMapping("/alluserproperties")
	public ModelAndView allUserProperties(ModelMap m,HttpSession session)
	{
		String emailid = (String)session.getAttribute("uname");
		List<PostProperty> prop_list = allpropsrv.showAllUserProp(emailid);
		
		for(PostProperty p : prop_list)
		{
			System.out.println("ALL USER SPECIFIC PROPERTIES");
			System.out.println(p.toString());
		}
		
		return new ModelAndView("allproperties","propList",prop_list);
	}
	@RequestMapping("/alluserrequirements")
	public ModelAndView allUserRequirements(ModelMap m,HttpSession session)
	{
		String emailid = (String)session.getAttribute("uname");
		List<PostRequirement> req_list = allreqsrv.showAllUserReq(emailid);
		
		for(PostRequirement r : req_list)
		{
			System.out.println("ALL USER SPECIFIC Requirements");
			System.out.println(r.toString());
		}
		
		return new ModelAndView("allrequirements","reqList",req_list);
	}
	
	@RequestMapping("/takepid")
	public ModelAndView takePropForUpdate(ModelMap m,HttpSession session)
	{
		String emailid = (String)session.getAttribute("uname");
		List<PostProperty> prop_list = allpropsrv.showAllUserProp(emailid);
		
		for(PostProperty p : prop_list)
		{
			System.out.println("ALL USER SPECIFIC PROPERTIES");
			System.out.println(p.toString());
		}
		
		return new ModelAndView("updateprop","propList",prop_list);
	}
	@RequestMapping("/takerid")
	public ModelAndView takeReqForUpdate(ModelMap m,HttpSession session)
	{
		String emailid = (String)session.getAttribute("uname");
		List<PostRequirement> req_list = allreqsrv.showAllUserReq(emailid);
		
		for(PostRequirement r : req_list)
		{
			System.out.println("ALL USER SPECIFIC Requirements");
			System.out.println(r.toString());
		}
		
		return new ModelAndView("updatereq","reqList",req_list);
	}
	
	@RequestMapping("/deleteprop")
	public  String delProperty(HttpSession session,HttpServletRequest request)
	{
		List<PostProperty> list = new ArrayList<PostProperty>();
		String [] SelectedProperties = request.getParameterValues("propertyinfo");
		if(SelectedProperties!=null)
		{
			for (String propertyid : SelectedProperties) 
			{			
				delsrv.deleteProp(Long.parseLong(propertyid));
				System.out.println("Property Deleted Sucessfully");
				
			}
		}
		return "redirect:/individual/homepage";
	}
	
	@RequestMapping("/deletereq")
	public  String delRequirement(HttpSession session,HttpServletRequest request)
	{
		List<PostRequirement> list = new ArrayList<PostRequirement>();
		String [] Selectedrequirements = request.getParameterValues("requirementinfo");
		if(Selectedrequirements!=null)
		{
			for (String requirementid : Selectedrequirements) 
			{
				delsrv.deleteReq(Long.parseLong(requirementid));
				System.out.println("Requirements Deleted Sucessfully");
			}
		}
		return "redirect:/individual/homepage";
	}
	
}
