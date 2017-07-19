package com.springmvc.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private Log log = LogFactory.getLog(TodoController.class);

	//variable to hold the APP view home directory for request mapping
	private static String appView = "todoview";
	
	// Set the todoDAO Service using dependency injection as an Auto-Wired
	@Autowired
	TodoDAOService todoDAO;
	
	/**
	 * @param binder
	 * This will bind the date class to format all dates as dd/mm/yy
	 * this method is used to format output
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named login
	 */
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET) //using the request mapping of"/list-todos" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String showTodos(ModelMap model) {
		
		//add the user name in the model for the navigation access
		//model.put("name", retrieveLoggedinUserName());
		
		//retrieve a list of todos from the database based on a user
		
		//add the list todos to the model, so that the front end will have some data to show
		model.addAttribute("todos", todoDAO.getListOfTodos(retrieveLoggedinUserName()));
		//model.addAttribute("todos", todoService.retrieveTodos(retrieveLoggedinUserName()));
		
		//the returned page name
		return appView+"/list-todos";
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
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named todo
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String showAddTodo(ModelMap model) {
		//System.out.println("About to launch the exception specific todoview../common/error-specific-page");
		//throw new RuntimeException("Dummy Exception");
		System.out.println("I'm HERE HERE HERE2222222222");
		//add the user name in the model for the navigation access
		model.put("name", retrieveLoggedinUserName());
		
		model.addAttribute("todo", new Todo(0, retrieveLoggedinUserName(), "Enter a Description","2012-12-12", false));
		return appView+"/todo";
		
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named todo
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	//public String addTodo(ModelMap model, @RequestParam String desc) { you can use the @RequestParam to pass param or pass an entire object	
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		System.out.println("I'm HERE HERE HERE\n" + todo.getDesc() + " - " + todo.getTargetDate());
		if(result.hasErrors()){
			return appView+"/todo";
		}
		//todoService.addTodo(retrieveLoggedinUserName(), todo.getDesc(), new Date(), false);
		todoDAO.insertTodoByUsername(retrieveLoggedinUserName(), todo.getDesc(), todo.getTargetDate(), false);
		
		model.clear();
		//the returned page name
		return "redirect:/list-todos";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String deleteTodo(ModelMap model, @RequestParam String id) {
				
		//todoService.deleteTodo(id);
		todoDAO.deleteTodo(id,"amine89");
		model.clear();
		//the returned page name
		return "redirect:/list-todos";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String updateTodo(ModelMap model, @RequestParam int id) {
		log.info("inside /update-todo");		
		//Todo todo = todoService.retrieveTodo(id);
		Todo todo = todoDAO.getATodoByID_USERNAME(id, retrieveLoggedinUserName());
		model.addAttribute(todo);
		
		//the returned page name
		return appView+"/todo";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		//update the todo
		if(result.hasErrors()){
			return appView+"/todo";
		}
		todo.setUser(retrieveLoggedinUserName());
		
		//todoService.updateTodo(todo);
		todoDAO.updateTodo(todo.getDesc(), todo.getTargetDate(), todo.getId(), todo.getUser());
		
		//the returned page name
		return "redirect:/list-todos";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/*
	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest req, Exception exception) {
		System.out.println("let's throw this thing");
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		return "common/error-specific-page";
	}
	*/
}
