package com.springmvc.todo;

import javax.validation.constraints.Size;

public class Todo {

	private int id;
	private String user;
	
	//Using the annotation @size below allows us to do validation using Hibernate validators
	@Size(min = 10, message = "Enter atleast 10 Characters.")
	private String desc;
	
	private String targetDate;
	private boolean isCompleted;

	//default constructor
	public Todo(){
		
	}
	public Todo(int id, String user, String desc, String targetDate, boolean isCompleted) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the targetDate
	 */
	public String getTargetDate() {
		return targetDate;
	}

	/**
	 * @param targetDate the targetDate to set
	 */
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * @return the isCompleted
	 */
	public boolean isDone() {
		return isCompleted;
	}

	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setDone(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}	
}
