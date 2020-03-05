package com.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class Deserialization
{
	public static void main(String args[])
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		PreparedStatement ps = con.prepareStatement("select * from objstore25 where id=?");
		System.out.println("Enter the Id");
		ps.setString(1,sc.nextLine());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
		Blob b = rs.getBlob(2);
		byte by[]=b.getBytes(1,(int)b.length());
		File f = new File("G:\\java by Vivek\\java Program\\Img\\obj.txt");
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(by);
		fos.close();
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		TransLog obj2=(TransLog)ois.readObject();
		fis.close();
		f.deleteOnExit();
		System.out.println("Log details");
		System.out.println(obj2);
		}
		else{
			System.out.println("Invalid Id:");
		}
		}
		
		catch(SQLException | ClassNotFoundException | IOException ob)
		{
			ob.printStackTrace();
		}
		
	}
}
