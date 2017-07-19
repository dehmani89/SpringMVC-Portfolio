package com.springmvc.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	//variable to hold the APP view home directory for request mapping
	private static String appView = "loginview";
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named login
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //using the request mapping of"/" the servlet used this controller as the default controller "LoginController"
	public String showLoginPage(ModelMap model) {
		
		//add the user name in the model for the navigation access
		model.put("name", retrieveLoggedinUserName());
				
		//the returned page name
		return appView+"/welcome";
	}
	
	/**
	 * 
	 * @return principal (which is the user name that is logged in)
	 */
	private String retrieveLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails){
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();		
	}
}
