package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Train25 {

private static final String INSERT_INTO_TRAIN25 = "INSERT INTO TRAIN25 VALUES(?,?,?,?)";
	

	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		int k = 0;
		int trainNo = 0;
		String trainName = null;
		String source = null;
		String dest = null;
			
		Scanner sc = null;
		sc = new Scanner(System.in);
		
		System.out.println("\n Enter the Train number::");
		trainNo = sc.nextInt();
		
		System.out.println("\n Enter the Train Name::");
		trainName = sc.next();
		
		System.out.println("\n Enter the Source::");
		source = sc.next();
		
		System.out.println("\n Enter the Destination");
		dest = sc.next();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		PreparedStatement ps = con.prepareStatement(INSERT_INTO_TRAIN25);
		
		ps.setInt(1,trainNo);
		ps.setString(2,trainName);
		ps.setString(3,source);
		ps.setString(4,dest);
		
		k = ps.executeUpdate();
		if(k>0)
			System.out.println("Data inserted Successfully");
		else
			System.out.println("Failed");
		ps.close();
		con.close();
		sc.close();
	} 
}
