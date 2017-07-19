package com.springmvc.users;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.security.SecurityConfiguration;
import com.springmvc.todo.Todo;

@Controller
public class ProfileController {
	
	private Log log = LogFactory.getLog(ProfileController.class);
	
	//variable to hold the APP view home directory for request mapping
	private static String appView = "profilemanagement";

	// Set the todoDAO Service using dependency injection as an Auto-Wired
	@Autowired
	ProfileDAOService profileDAOService;
	
	
	
	/**
	 * the GET method type should be used to retrieve data from the server side
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/profile-management", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String showProfileInformation(ModelMap model) {
		System.out.println("inside GET /profile-management");
		//System.out.println("username is ~~~" + username);
		
		//UserInfo userInfo = profileDAOService.getUserData("amine89");
		UserInfo userInfo = profileDAOService.getUserData(SecurityConfiguration.retrieveLoggedinUserName());
		model.addAttribute(userInfo);
		model.addAttribute("updateprofile", userInfo);
		
		//the returned page name
		return appView+"/profilepage";	//return redirect directive
	}
	
	/**
	 * the POST method type should be used to create, Update/Delete data from the server side
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/profile-management", method = RequestMethod.POST) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String updateProfileInformation(ModelMap model, @Valid UserInfo userInfo, BindingResult result) {
		System.out.println("inside POST /profile-management");
		
		System.out.println("Let's send updates to the database");
		profileDAOService.updateUserInfo(userInfo);		
		//System.out.println(userInfo.getFirstname());
		//System.out.println(userInfo.getLastname());
		//System.out.println(userInfo.getCity());
//		if(result.hasErrors()){
//			System.out.println("results has errors");
//			System.out.println(result.hasErrors());
//			return appView+"/profilepage";
//		}
		
		//Todo todo = todoService.retrieveTodo(id);
		//Todo todo = todoDAO.getATodoByID_USERNAME(id, retrieveLoggedinUserName());
		//model.addAttribute(todo);
		
		//the returned page name
		return "redirect:/"; //this will take you back to the welcome page
	}
	
}
