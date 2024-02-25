package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCInsert {
	public static void main(String[] args) throws SQLException {
		
		/* Steps to connect java application with database application */
		//1. Load and register the drivers			
			Driver driver = new Driver();		//Load Driver
			DriverManager.deregisterDriver(driver);		//register Driver
			
		//2. Open Connection between java application and database application
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
														//dburl	-->	//jdbc:db_plateform://system:portNumber/db_name?user=""&&password=""
		//Create the statements
			Statement statement = connection.createStatement();
			
		//Execute the statements
			statement.execute("INSERT INTO user VALUES(1,'Ramesh','ramesh@gmail.com','Ramesh@1234')");
			
		//Process the Result
			System.out.println("Data Inserted");
			
		//Close the Connection between java application and database application
			statement.close();
			connection.close();
			
		//DeRegister the drivers
			DriverManager.deregisterDriver(driver);
	}
}
