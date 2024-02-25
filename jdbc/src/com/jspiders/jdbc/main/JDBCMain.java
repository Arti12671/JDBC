package com.jspiders.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.jdbc.operations.JDBCService;

public class JDBCMain {
    public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.Sign Up\n"+"2.Log In\n"+"3.to exit");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				JDBCService.signUp(scanner);
				break;
			case 2:
				JDBCService.logIn(scanner);
				break;
			case 3:
				flag = false;
				System.out.println("Thank you!!");
		    default:
		    	System.out.println("Invalid choice");
			}
		}
	}
}