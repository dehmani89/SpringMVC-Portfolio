package com.springmvc.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.springmvc.database.DBHelper;
import com.springmvc.todo.TodoDAOService;

@Service
public class ProfileDAOService {

	final static Logger log = Logger.getLogger(TodoDAOService.class);
	
	//Queries Defined
	final   String SELECT_USER_DATA_QUERY 	= "SELECT * FROM users WHERE username = ? ";
	final   String UPDATE_USER_DATA_QUERY 	= "UPDATE users SET password = ?, firstname = ?, lastname = ?, email = ?, occupation = ?, education = ?, city = ?, state = ?, skills = ? WHERE id = ? " ;

	/**
	 * @param id
	 * @return userinfo by username
	 */
	public UserInfo getUserData(String _username) {
		
		log.info("INSIDE getUserData METHOD");
		UserInfo userinfo = new UserInfo();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(SELECT_USER_DATA_QUERY);

			// STEP 2: set any needed parameters
			ps.setString(1, _username);

			log.info("Executing the following Query: " + SELECT_USER_DATA_QUERY);
			ResultSet rs = ps.executeQuery();

			// STEP 3: Extract data from result set			
			if(!rs.next()){
				log.info("No data was found for user name: " + _username);
			}else{
				do{
					// Retrieve by column name
					userinfo.setUsername(rs.getString("username"));
					userinfo.setPassword(rs.getString("password"));
					userinfo.setEnabled(rs.getInt("enabled"));
					userinfo.setId(rs.getInt("id"));
					userinfo.setFirstname(rs.getString("firstname"));
					userinfo.setLastname(rs.getString("lastname"));
					userinfo.setEmail(rs.getString("email"));
					userinfo.setEducation(rs.getString("education"));
					userinfo.setOccupation(rs.getString("occupation"));
					userinfo.setCity(rs.getString("city"));
					userinfo.setState(rs.getString("state"));
					//List<String> skillsList = Arrays.asList(skills.split(","));
					userinfo.setSkills(rs.getString("skills"));
					
					// log Users data into the system
					log.info("\nCurrent User Info:\n---------------------\n");
					log.info(userinfo.toString());
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
		return userinfo;
	}	
	
	
	/**
	 * @param userInfo
	 */
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("INSIDE UPDATE METHOD");
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// STEP 1: get a connection to the database
			conn = DBHelper.connectToDatabase("EDW");
			ps = conn.prepareStatement(UPDATE_USER_DATA_QUERY);

			// STEP 2: set any needed parameters
			//ps.setString(1, userInfo.getUsername());
			//ps.setString(1, "amine89");
			ps.setString(1, userInfo.getPassword());
			//ps.setInt(2, userInfo.getEnabled());
			ps.setString(2, userInfo.getFirstname());
			ps.setString(3, userInfo.getLastname());
			ps.setString(4, userInfo.getEmail());
			ps.setString(5, userInfo.getOccupation());
			ps.setString(6, userInfo.getEducation());
			ps.setString(7, userInfo.getCity());
			ps.setString(8, userInfo.getState());
			ps.setString(9, userInfo.getSkills());
			ps.setInt(10, userInfo.getId());
			//ps.setString(13, userInfo.getUsername());

			System.out.println("---------------New Data Sent----------------------");
			System.out.println(userInfo.toString());
			System.out.println("-------------------------------------");
			//System.out.println(userInfo.getUsername());
			//System.out.println(userInfo.getPassword());
			//System.out.println(userInfo.getEnabled());
			//System.out.println(userInfo.getFirstname());
			//System.out.println(userInfo.getLastname());
			//System.out.println(userInfo.getEmail());
			//ps.setInt(7, userInfo.getId());
			//System.out.println(userInfo.getOccupation());
			//System.out.println(userInfo.getEducation());
			//System.out.println(userInfo.getCity());
			//System.out.println(userInfo.getState());
			//System.out.println(userInfo.getSkills());
			//System.out.println(userInfo.getId());
			
			log.info("Executing the following Query: " + UPDATE_USER_DATA_QUERY);
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
	
}
