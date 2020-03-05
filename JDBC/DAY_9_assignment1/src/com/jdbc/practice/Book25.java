package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book25 {
	
	private static final String INSERT_INTO_BOOK25 = "INSERT INTO BOOK25 VALUES(?,?,?,?,?)";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int res = 0;
		String bCode = null;
		String bName = null;
		String bAuthor = null;
		double bPrice = 0;
		int bQty = 0;
		Scanner sc = null;
		sc = new Scanner(System.in);
		
		System.out.println("Enter the Book Code::\n");
		bCode = sc.nextLine();
		
		System.out.println("Enter the Book Name::\n");
		bName = sc.nextLine();
		
		System.out.println("Enter the Book Author::\n");
		bAuthor = sc.nextLine();
		
		System.out.println("Enter the Price::\n");
		bPrice = sc.nextDouble();
		
		System.out.println("Enter the Quantity::\n");
		bQty = sc.nextInt();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "916776");
		
		PreparedStatement ps = con.prepareStatement(INSERT_INTO_BOOK25);
		
		ps.setString(1, bCode);
		ps.setString(2, bName);
		ps.setString(3, bAuthor);
		ps.setDouble(4, bPrice);
		ps.setInt(5, bQty);
		
		res = ps.executeUpdate();
		if(res>0)
			System.out.println("Data Inserted Successfully");
		else
			System.out.println("Failed");
		
		ps.close();
		con.close();
		sc.close();
		
	}
}
