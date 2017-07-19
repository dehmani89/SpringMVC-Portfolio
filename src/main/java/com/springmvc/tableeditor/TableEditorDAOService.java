package com.springmvc.tableeditor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.springmvc.database.DBHelper;
import com.springmvc.todo.TodoDAOService;

@Service
public class TableEditorDAOService {

	final static Logger log = Logger.getLogger(TableEditorDAOService.class);
	
	//Queries Defined
	//final   String SELECT_POLICY_DATA_QUERY 	= "SELECT * FROM policydata WHERE policynumber = ? ";

//	/**
//	 * @param policyNumber
//	 * @return Policy
//	 */
//	public Policy getPolicyData(String policyNumber) {
//		
//		log.info("INSIDE getUserData METHOD");
//		Policy policyinfo = new Policy();
//		Connection conn = null;
//		PreparedStatement ps = null;
//
//		try {
//			// STEP 1: get a connection to the database
//			conn = DBHelper.connectToDatabase("EDW");
//			ps = conn.prepareStatement(SELECT_POLICY_DATA_QUERY);
//
//			// STEP 2: set any needed parameters
//			ps.setString(1, policyNumber);
//
//			log.info("Executing the following Query: " + SELECT_POLICY_DATA_QUERY);
//			ResultSet rs = ps.executeQuery();
//
//			// STEP 3: Extract data from result set			
//			if(!rs.next()){
//				log.info("No data was found for user name: " + policyNumber);
//			}else{
//				do{
//					// Retrieve by column name
//					//policyinfo.set(rs.getString("username"));
//										
//					// log Users data into the system
//					log.info("\nCurrent User Info:\n---------------------\n");
//					log.info(policyinfo.toString());
//				}while (rs.next());
//			}
//			rs.close();
//		} catch (SQLException se) {
//			// Handle errors for JDBC
//			se.printStackTrace();
//		} catch (Exception e) {
//			// Handle errors for Class.forName
//			e.printStackTrace();
//		} finally {
//			// finally block used to close resources
//			try {
//				if (ps != null)
//					conn.close();
//			} catch (SQLException se) {
//			} // do nothing
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			} // end finally try
//		} // end try
//		return policyinfo;
//	}	
//	
	

}
