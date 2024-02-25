package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert3 {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
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
			query = "INSERT INTO user VALUES(3,'Mahesh','mahesh@gmail.com','Mahesh@1234')";
			statement.execute(query);
			System.out.println("Data inserted");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {                                                                                                                                                                                                                                                                                                                                                             
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
