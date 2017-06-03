package com.springmvc.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
		
		model.put("name", "amine89");
		
		//the returned page name
		return appView+"/welcome";
	}
}
