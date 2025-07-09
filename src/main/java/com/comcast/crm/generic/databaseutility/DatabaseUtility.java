package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	public void getDBConnection(String url, String username, String password) {
		try {
		Driver driver = new Driver();
	    DriverManager.registerDriver(driver);
	    
	    con = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {

		}	
	}
	
	public void getDBConnection() {
		try {
		Driver driver = new Driver();
	    DriverManager.registerDriver(driver);
	    
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		}catch (Exception e) {

		}	
	}
	
	public void closeDBConnection() {
		try {
			con.close();
		} catch (Exception e) {
		}
	}
	
	public ResultSet executeConSelectQuery(String query) {
		ResultSet res = null;
		try {
			Statement stat = con.createStatement();
			res = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return res;
	}
	
	public int executeConNonSelectQuery(String query) {
		int res= 0;
		try {
		Statement stat = con.createStatement();
		res = stat.executeUpdate(query);
		}catch (Exception e) {
		}
		return res;
	}
	
	

}
