package com.springmvc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.todo.Todo;
import com.springmvc.todo.TodoService;

@RestController
public class RestTodoController {

	@Autowired
	TodoService service;
	
	/**
	 * @RequestMapping(path="/todos") the path param here is used to identify the rest web service
	 * @return list of users and their todos as a JSON object
	 */
	@RequestMapping(path="/todos")
	public List<Todo> retrieveAllTodos(){
		List<Todo> users = service.retrieveTodos("amine89");
		return users;
	}
	
	/**
	 * @param id
	 * @return return a list of todos based on an ID
	 * @pathVariable us used so that we can pass the ID as a URLD
	 * http://localhost:8080/todos/1
	 */
	@RequestMapping(path="/todos/{id}")
	public Todo retrieveTodo(@PathVariable int id){
		Todo todo = service.retrieveTodo(id);
		return todo;
	}
	
}
