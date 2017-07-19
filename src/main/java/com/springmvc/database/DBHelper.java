package com.springmvc.database;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBHelper {
	
	final static Logger log = Logger.getLogger(DBHelper.class);

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";

	//  Database credentials
	static final String USER = "amine89";
	static final String PASS = "dehmani89";
	
	public static Connection connectToDatabase(String database){
		//Define a connection
		Connection conn = null;
		
		//STEP 1: Register JDBC driver
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			log.info("Setting up the Class Forname:" + "com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			log.info("ClassNotFoundException has occured \n" + e);
		}

	    //STEP 2: Open a connection
	    try {
			conn = DriverManager.getConnection(DB_URL+database, USER, PASS);
			log.info("Connected database: " + database + " successfully\n");
			return conn;
		} catch (SQLException e) {
			log.info("SQLException has occured \n" + e);
		}	    
	    return conn;
	}
}
