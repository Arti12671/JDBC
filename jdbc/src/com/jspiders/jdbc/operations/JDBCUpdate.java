package com.jspiders.jdbc.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUpdate {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;

	private static void openConnection() throws SQLException, IOException {
		File file = new File("F:/File/db_info.txt");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();	//(java.util package) concrete and container class 
		properties.load(fileReader); // load the file reader

		connection = DriverManager.getConnection(properties.getProperty("url"), properties); // to get the property(key)
																								// from the file
	}

	private static void closeConnection() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
			query = "UPDATE user SET password = 'Mahesh@5678' WHERE id = 3";
			statement.execute(query);
			System.out.println("Password Updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
