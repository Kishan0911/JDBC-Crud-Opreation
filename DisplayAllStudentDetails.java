package com.ibm.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DisplayAllStudentDetails {
	
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
		
		String DiaplayAllDetailsQuery = "select * from student ";
		
		ResultSet set = statement.executeQuery(DiaplayAllDetailsQuery);
		   
		  while(set.next()) {
			  int id = set.getInt("id");
			  String name = set.getNString("name");
			  String email = set.getString("email");
			  Object dob = set.getObject("dob");
			  long phone = set.getLong("phone");
			  
			  System.out.println("====================================");
			  
			  System.out.println(" id is : " +id);
			  System.out.println(" Name is : " +name);
			  System.out.println(" Email is : " +email);
			  System.out.println(" DOB is : " +dob);
			  System.out.println(" Phone number is : " +phone);
		  }
		
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
