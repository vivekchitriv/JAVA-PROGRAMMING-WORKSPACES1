package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Serialization {
	public static void main(String[] args) throws ClassNotFoundException,IOException,SQLException 
	{
		Scanner sc = new Scanner(System.in);
		TransLog ob = new TransLog(Math.random(),6123456L,12000,new java.util.Date());
		File f = new File("G:\\java by Vivek\\java Program\\Img\\obj.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ob);
		FileInputStream fis = new FileInputStream(f);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		PreparedStatement ps = con.prepareStatement("insert into ObjStore25 values(?,?)");
		System.out.println("Enter the id:");
		ps.setString(1,sc.nextLine());
		ps.setBinaryStream(2, fis,(int)f.length());
		int k = ps.executeUpdate();
		if(k>0)
		{
			System.out.println("Object stored Successfullt...");
			
		}
		fis.close();
		
		
	}

	
}
