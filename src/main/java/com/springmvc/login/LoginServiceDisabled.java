package com.springmvc.login;

import org.springframework.stereotype.Service;

@Service	//using the @Service annotation makes the LoginService class available as a bean
public class LoginServiceDisabled {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("amine89") && password.equals("dehmani89");
	}

}