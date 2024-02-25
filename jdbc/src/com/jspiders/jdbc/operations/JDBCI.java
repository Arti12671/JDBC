package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCI {

	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			statement=connection.createStatement();
			query="INSERT INTO employee VALUES(1,'Avnish','Sales')";
			statement.execute(query);
			System.out.println("Data Inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void openConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
	}
	public static void closeConnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
	
}