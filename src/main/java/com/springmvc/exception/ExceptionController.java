package com.springmvc.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {

	//variable to hold the APP view home directory for request mapping
	private static String appView = "common";
	
	private Log logger = LogFactory.getLog(ExceptionController.class);

	/**
	 * @param req
	 * @param exception
	 * @return the standard error page 
	 */
	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		return appView + "/error";
	}
}