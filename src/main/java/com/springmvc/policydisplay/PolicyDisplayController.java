package com.springmvc.policydisplay;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.users.UserInfo;

@Controller
public class PolicyDisplayController {

	private Log log = LogFactory.getLog(PolicyDisplayController.class);

	// variable to hold the APP view home directory for request mapping
	private static String appView = "policydisplay";

	// Set the todoDAO Service using dependency injection as an Auto-Wired
	@Autowired
	PolicyDisplayDAOService policyDisplayDAOService;

	/**
	 * the GET method type should be used to retrieve data from the server side
	 * the method below will return the name of the file to show when called
	 * value -> this is the mapping value to be used method -> this is the type
	 * of acceptable method to be used
	 * 
	 * @return view
	 */
	@RequestMapping(value = "/policy-display", method = RequestMethod.GET)
	public String showProfileInformation(ModelMap model) {
		System.out.println("inside GET /policy-display");
		// the returned page name
		return appView + "/policyview"; 
	}

	/**
	 * the POST method type should be used to create, Update/Delete data from
	 * the server side the method below will return the name of the file to show
	 * when called value -> this is the mapping value to be used method -> this
	 * is the type of acceptable method to be used
	 * 
	 * @return view
	 */
	@RequestMapping(value = "/policy-display", method = RequestMethod.POST)
	public String updateProfileInformation(ModelMap model, @Valid UserInfo userInfo, BindingResult result) {
		System.out.println("inside POST /policy-display");
		// the returned page name
		return "redirect:/policyview";
	}
}
