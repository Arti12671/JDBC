package com.jspiders.jdbc.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCall {
	private static Connection connection;
	private static ResultSet resultSet;
	private static CallableStatement callableStatement;
	private static String query;
	public static void openConnection() throws SQLException {
    	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
    }

	public static void closeConnection() throws SQLException {
		if (callableStatement != null) {
			callableStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
	
     public static void main(String[] args) throws SQLException {
		try {
			openConnection();
			query = "call P2()";
			callableStatement = connection.prepareCall(query);
			callableStatement.execute();
			resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
}