package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert2 {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;

	private static void openConnection() throws SQLException {
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
	}

	private static void closeConnection() throws SQLException {
		if (statement != null) {
			statement.close();
		}		
		if (connection != null) {
			connection.close();
		}
		
		DriverManager.deregisterDriver(driver);
	}

	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
//			query = "INSERT INTO user VALUES(2,Suresh','suresh@gmail.com','Suresh@1234')";
			query = "INSERT INTO car VALUES(4,'nano','maruti','xyz','cng',132000.0,'black')";
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
