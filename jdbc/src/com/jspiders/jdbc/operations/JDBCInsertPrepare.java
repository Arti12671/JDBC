package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsertPrepare {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Id : ");
		int id = scanner.nextInt();
		System.out.println("Enter the Name : ");
		String name = scanner.next();
		System.out.println("Enter the Email : ");
		String email = scanner.next();
		System.out.println("Enter the Password : ");
		String password = scanner.next();

		try {
			openConnection();
			query = "INSERT INTO user VALUES(?, ?, ?, ?)";// ? (placeholder) denotes the unknown values
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			int res = preparedStatement.executeUpdate();
			System.out.println(res +" row(s) affected");

		} catch (Exception e) {
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
