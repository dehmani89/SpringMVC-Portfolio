package com.springmvc.database;

//STEP 1. Import required packages
import java.sql.*;
import org.apache.log4j.Logger;

import com.springmvc.users.UserInfo;

public class DatabaseConnection {

	final static Logger log = Logger.getLogger(DatabaseConnection.class);

	public static void main(String[] args) {

		//pass the user name you want
		UserInfo currentUserInfo = getUserInfo("amine8");
		if( currentUserInfo != null){
			log.info("Logged in as " + currentUserInfo.getUsername());
		}else{
			log.info("User Data is not available");
		}
	}// end main

	public static UserInfo getUserInfo(String _username) {
		
		UserInfo userInfo = null;

		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "SELECT * FROM users WHERE username=?";

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(sql);

			// STEP 2: set any needed parameters
			ps.setString(1, _username);

			log.info("Executing the following Query: " + sql);
			ResultSet rs = ps.executeQuery();

			// STEP 3: Extract data from result set			
			if(!rs.next()){
				log.info("No data was found for user name: " + _username);
			}else{
				do{
					//if data found create a new user info object
					userInfo = new UserInfo();
					
					// Retrieve by column name
					int id = rs.getInt("id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String email = rs.getString("email");
					String username = rs.getString("username");
					String password = rs.getString("password");
	
					userInfo.setId(id);
					userInfo.setFirstname(firstname);
					userInfo.setLastname(lastname);
					userInfo.setEmail(email);
					userInfo.setUsername(username);
					userInfo.setPassword(password);
					
					// log Users data into the system
					log.info("\nCurrent User Info:\n---------------------\n" + "User ID:\t" + id + "\nUser name:\t" + username + "\nFirst name:\t" + firstname + "\nLast name:\t" + lastname);
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

		return userInfo;
	}
}// end JDBCExample
