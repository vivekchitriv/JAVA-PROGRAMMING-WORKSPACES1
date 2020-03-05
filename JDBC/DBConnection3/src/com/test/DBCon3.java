package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBCon3 {
	private static final String INSERTINTOPRODUCT25 = "INSERT INTO PRODUCT25 VALUES(?,?,?,?)";
	public static void main(String[] args)throws ClassNotFoundException,SQLException 
	{
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
			PreparedStatement ps = con.prepareStatement(INSERTINTOPRODUCT25);
			System.out.println("\nEnter the Number of Records::");
			int n = Integer.parseInt(sc.nextLine());
			for(int i=1 ; i<=n;i++)
			{
				System.out.println("\n Enter the pCode::");
				ps.setString(1, sc.nextLine());
				System.out.println("\n Enter the pName::");
				ps.setString(2, sc.nextLine());
				System.out.println("\n Enter the pPrice::");
				ps.setFloat(3, Float.parseFloat(sc.nextLine()));
				System.out.println("\n Enter the pQty::");
				ps.setInt(4, Integer.parseInt(sc.nextLine()));
			
			int k = ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Product data Inserted...");
			}
			}
			con.close();
			sc.close();
		
		
		
	}
}
