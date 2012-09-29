package com.property.controllers;

import java.math.BigInteger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.property.models.Register;
import com.property.models.SpringUsers;
import com.property.services.RegisterService;
import com.property.services.SpringRolesService;
import com.property.services.SpringUsersService;

@RequestMapping("/register")
@Controller
public class RegisterController {
	@Autowired
	RegisterService regsvc;
	@Autowired
	SpringUsersService susvc;
	@Autowired
	SpringRolesService srsvc;
	
	
	//Sending a Register Model To Registration Page
	@RequestMapping("/newuser")
	public ModelAndView newUser() {		
		Register reg = new Register();
		reg.setUser_type("ROLE_INDIVIDUAL");
		reg.setEmail_id("abc@xyz.com");
		reg.setFirst_name("First Name");
		reg.setCity("pune");
		reg.setMb_no(new BigInteger("9876543210"));
		return new ModelAndView("register", "rg", reg);
	}
	
	@RequestMapping("/createuser")
	public ModelAndView createUser(@ModelAttribute("rg") Register reg) {
		int i = regsvc.registerNewUser(reg);
		
		return new ModelAndView("usercreated");
		

	}
	
	@RequestMapping("/changepassword")
	public ModelAndView changepassword(HttpSession session)
	{
		String name = (String)session.getAttribute("uname");
		susvc.getCredentials(name);
		return new ModelAndView();
	}
	
	//Controller for creating new authenticated user with his role 
	@RequestMapping("/createnewuser")
	public ModelAndView userCreated(@ModelAttribute("rg") Register reg) {
		
		BigInteger num = reg.getMb_no();
		System.out.println("mbno="+num.toString());
		//Doing the entry of New User in Spring_Users table
		
		String username = reg.getEmail_id();
		String password = reg.getPassword();
		SpringUsers su = new SpringUsers();
		su.setUsername(username);
		su.setPassword(password);
		su.setEnabled(1);
		System.out.println("username="+username);
		System.out.println("password="+password);
		
		
		
		String r = reg.getUser_type();
		
		//if(r.equals("ROLE_INDIVIDUAL"))
			//return new ModelAndView("individualhomepage");
		//if(r.equals("ROLE_BROKER"))
	//		return new ModelAndView("brokerhomepage");
		//if(r.equals("ROLE_BUILDER"))
		//	return new ModelAndView("builderhomepage");
		
	//	int i = susvc.entryOfNewUser(su);
		
		int j = regsvc.registerNewUser(reg);
		 
		return new ModelAndView("usercreated");

	}
}
