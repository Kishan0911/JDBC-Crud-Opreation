package com.ibm.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentController {
	

	public static void main(String[] args) {
		
		Connection connection = null;
		
		// Step 1 :- Load/Register Driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step :- Create connection
		
		String url = "jdbc:mysql://localhost:3306/jdbc-e3";
		String username = "root";
		String pass = "root";
		
		connection=DriverManager.getConnection(url, username, pass);
		
		System.out.println(connection);
		
		// Step 3 :- Create Statement
		
		Statement statement = connection.createStatement();	
		
		// Step 4 :- Execute Query
		
		String DeleteStudentQuery = " delete from student where id=124";;
		
		int a = statement.executeUpdate(DeleteStudentQuery);
		
		if(a!=0)
			System.out.println(" Data Deleted");
		else
			System.out.println("GIven id is not found");
		   
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
