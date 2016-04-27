/*
 * set up mysql database connection 
 */
package edu.pitt.DbConnect;

/**
 * @author siying
 * Connect to MySQL
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	//static reference to itself
	private static DbConnection instance = new DbConnection();
	
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:8889/scopingsim";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	//private constructor
	public DbConnection() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR: Unable to connect to Database!");
		}
		return connection;
	}
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}
