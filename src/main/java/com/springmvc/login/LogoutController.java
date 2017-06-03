package com.springmvc.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
		
	/**
	 * @param request
	 * @param response
	 * the method below will redirect to "/" which is the home log in controller
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * The method also creates an Authentication to remove the current user from session
	 * All this happens when the user clicks on the logout link on the navigation menu
	 * @return view named / or home
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET) //using the request mapping of"/" the servlet used this controller as the default controller "LoginController"
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		//terminate the authentication when user logs out
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			//to be completely safe, lets invalidate the session as well
			request.getSession().invalidate();
		}
		
		//the returned page name
		return "redirect:/";
	}
}
