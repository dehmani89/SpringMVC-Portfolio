package com.springmvc.todo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.springmvc.database.DBHelper;

@Service				//using the @Service annotation makes the TodoService class available as a bean
public class TodoDAOService {
	
	final static Logger log = Logger.getLogger(TodoDAOService.class);

	//Define queries to be performed
	final static  String LIST_TODOS_QUERY 		= "SELECT * FROM todos_list WHERE username=?";
	final static  String GET_TODO_BY_ID_QUERY 	= "SELECT * FROM todos_list WHERE id = ? and username = ? ";
	final static  String DELETE_TODO_QUERY 		= "DELETE FROM todos_list WHERE id = ? and username = ? ";
	final static  String UPDATE_TODO_QUERY 		= "UPDATE todos_list SET description = ? , targetDate = ? WHERE id = ? and username = ? ";
	final static  String ADD_TODO_QUERY 		= "INSERT INTO todos_list(username, description, targetDate, isDone) VALUES (?,?,?,?)";;

	/**
	 * @param id
	 * @return todo by id
	 */
	public Todo getATodoByID_USERNAME(int _id, String _username) {
		log.info("INSIDE getATodoByID METHOD");
		Todo todo = new Todo();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(GET_TODO_BY_ID_QUERY);

			// STEP 2: set any needed parameters
			ps.setInt(1, _id);
			ps.setString(2, _username);

			log.info("Executing the following Query: " + GET_TODO_BY_ID_QUERY);
			ResultSet rs = ps.executeQuery();

			// STEP 3: Extract data from result set			
			if(!rs.next()){
				log.info("No data was found for user name: " + _username);
			}else{
				do{
					// Retrieve by column name
					int id 				= rs.getInt("id");
					String username 	= rs.getString("username");
					String description 	= rs.getString("description");
					String targetDate 	= rs.getString("targetDate");
					Boolean isDone 		= rs.getBoolean("isDone");
	
					todo.setId(id);
					todo.setUser(username);
					todo.setDesc(description);
					todo.setTargetDate(targetDate);
					todo.setDone(isDone);
					
					// log Users data into the system
					log.info("\nCurrent TODO Info:\n---------------------\n");
					log.info(id + " - " + username + " - " + description + " - " + targetDate + " - " + isDone + " - ");
				}while (rs.next());
			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (ps != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return todo;
	}	
	
	/**
	 * @param _username
	 * @return List of Todos
	 */
	public List<Todo> getListOfTodos(String _username) {
		log.info("INSIDE getListOfTodos METHOD");
		ArrayList<Todo> todos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(LIST_TODOS_QUERY);

			// STEP 2: set any needed parameters
			ps.setString(1, _username);

			log.info("Executing the following Query: " + LIST_TODOS_QUERY);
			ResultSet rs = ps.executeQuery();

			// STEP 3: Extract data from result set			
			if(!rs.next()){
				log.info("No data was found for user name: " + _username);
			}else{
				do{
					//if data found create a new user info object
					Todo todo = new Todo();
					
					// Retrieve by column name
					int id 				= rs.getInt("id");
					String username 	= rs.getString("username");
					String description 	= rs.getString("description");
					String targetDate 	= rs.getString("targetDate");
					Boolean isDone 		= rs.getBoolean("isDone");
	
					todo.setId(id);
					todo.setUser(username);
					todo.setDesc(description);
					todo.setTargetDate(targetDate);
					todo.setDone(isDone);
					
					// log Users data into the system
					log.info("\nCurrent TODO Info:\n---------------------\n");
					log.info(id + " - " + username + " - " + description + " - " + targetDate + " - " + isDone + " - ");
					
					//add the todo to the todos object
					todos.add(todo);
					
				}while (rs.next());
			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (ps != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return todos;
	}
	
	/**
	 * @param _id
	 * @param _username
	 * @return List of Todos
	 */
	public void deleteTodo(String id, String username) {
		log.info("INSIDE DELETE METHOD");
		log.info(id);
		log.info(username);
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(DELETE_TODO_QUERY);

			// STEP 2: set any needed parameters
			ps.setString(1, id);
			ps.setString(2, username);

			log.info("Executing the following Query: " + DELETE_TODO_QUERY);
			ps.executeUpdate();
			log.info("Record is deleted!");
		} catch (SQLException e) {
			log.info(e.toString());

		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info(e.toString());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info(e.toString());
				}
			}

		}

	}
	
	
	/**
	 * @param _id
	 * @param _username
	 * @return List of Todos
	 */
	public void updateTodo(String desc, String targetDate, int id, String username) {
		log.info("INSIDE UPDATE METHOD");
		log.info(desc);
		log.info(targetDate);
		log.info(id);
		log.info(username);
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(UPDATE_TODO_QUERY);

			// STEP 2: set any needed parameters
			ps.setString(1, desc);
			ps.setString(2, targetDate);
			ps.setInt(3, id);
			ps.setString(4, username);

			log.info("Executing the following Query: " + UPDATE_TODO_QUERY);
			ps.executeUpdate();
			log.info("Record is Updated!");
		} catch (SQLException e) {
			log.info(e.toString());

		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info(e.toString());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info(e.toString());
				}
			}

		}

	}
	
	/**
	 * @param _isDone 
	 * @param _date 
	 * @param _desc 
	 * @param id
	 */
	public void insertTodoByUsername(String _username, String _desc, String _date, boolean _isDone) {
		log.info("INSIDE insertTodoByUsername METHOD");
		System.out.println(_username);
		System.out.println(_desc);
		System.out.println(_date);
		System.out.println(_isDone);
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(ADD_TODO_QUERY);

			// STEP 2: set any needed parameters
			ps.setString(1, _username);
			ps.setString(2, _desc);
			ps.setString(3, _date);
			ps.setBoolean(4, _isDone);

			log.info("Executing the following Query: " + ADD_TODO_QUERY);
			ps.executeUpdate();
		} catch (SQLException e) {
			log.info(e.toString());
			e.printStackTrace();

		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info(e.toString());
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info(e.toString());
					e.printStackTrace();
				}
			}

		}
	}

}
