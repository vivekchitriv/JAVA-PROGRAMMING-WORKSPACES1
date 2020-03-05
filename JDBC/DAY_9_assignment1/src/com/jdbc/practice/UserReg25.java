package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserReg25 {
	private static final String INSERT_INTO_USERREG25 = "INSERT INTO USERREG25 VALUES(?,?,?,?,?,?,?)";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int res = 0;
		String uName = null;
		String pWord = null;
		String fName = null;
		String lName = null;
		String addrs = null;
		long phno = 0;
		int mid = 0;
		Scanner sc = null;
		sc = new Scanner(System.in);
		
		System.out.println("\n Enter the UserName ::");
		uName = sc.next();
		
		System.out.println("\n Enter the Password::");
		pWord = sc.next();
		
		System.out.println("\n Enter the First Name::");
		fName = sc.next();
		
		System.out.println("\n Enter the Last Name::");
		lName = sc.next();
		
		System.out.println("\n Enter the Address::");
		addrs = sc.next();
		
		System.out.println("\n Enter the Phone Number::");
		phno = sc.nextLong();
		
		System.out.println("\n Enter the Mid::");
		mid = sc.nextInt();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "916776");
		PreparedStatement ps = con.prepareStatement(INSERT_INTO_USERREG25);
		
		ps.setString(1, uName);
		ps.setString(2, pWord);
		ps.setString(3, fName);
		ps.setString(4, lName);
		ps.setString(5, addrs);
		ps.setLong(6, phno);
		ps.setInt(7, mid);
		
		res = ps.executeUpdate();
		if(res>0)
			System.out.println("Data Inserted successfully");
		else
			System.out.println("Failed");
		
		ps.close();
		con.close();
		sc.close();
		
		
	}
}
