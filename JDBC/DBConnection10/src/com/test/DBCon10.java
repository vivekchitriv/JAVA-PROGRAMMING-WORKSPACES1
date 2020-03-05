package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBCon10 {
	private static final String INSERT = "INSERT INTO PRODUCT25 VALUES(?,?,?,?)";
	private static final String DISPLAY = "SELECT * FROM PRODUCT25 WHERE PCODE=?";
	private static final String UPDATE = "UPDATE PRODUCT25 SET PQTY=? WHERE PCODE=?";
	private static final String DELETE = "DELETE FROM PRODUCT25 WHERE PCODE=?";
	 
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{	
		int n = 0;
		String pCode = null;
		ResultSet rs = null;
		Scanner sc = null;
		int res = 0;
		PreparedStatement ps = null;
		sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		
		
		
		while(true)
		{
			System.out.println("*****Enter your choice******");
			System.out.println("\n1. Insert "+"\n2. Update "+"\n3. Delete "+ "\n4. Display" +"\n5. Exit");
			n = Integer.parseInt(sc.next());
		switch(n)
		{
				case 1:
						System.out.println("Insert Operation..");
						ps = con.prepareStatement(INSERT); 
						System.out.println("Enter the the Prodcut code:");
						ps.setString(1,sc.next());
						System.out.println("Enter the Product Name:");
						ps.setString(2,sc.next());
						System.out.println("Enter the Product Price:");
						ps.setLong(3,Long.parseLong(sc.next()));
						System.out.println("Enter the product Quantity:");
						ps.setInt(4,Integer.parseInt(sc.next()));
						res = ps.executeUpdate();
						if(res>0)
						{
								System.out.println("Product data has been Updated Successfully...");
						}
						else
						{
								System.out.println("Failed...");
						}
						break;
					
				case 2:
						System.out.println("Update Operation...");
						ps = con.prepareStatement(DISPLAY);
						System.out.println("Enter the product code::");
						pCode = sc.next();
						ps.setString(1, pCode);
						rs = ps.executeQuery();
						if(rs.next())
						{	ps = con.prepareStatement(UPDATE);
							System.out.println("Old pqty:"+rs.getInt(4));
							System.out.println("enter the new product qty:");
							int pq = Integer.parseInt(sc.nextLine());
							ps.setInt(1, pq);
							ps.setString(2, pCode);
							int k = ps.executeUpdate();
							if(k>0)
							{
								System.out.println("Prdouct qty has been successfully updated...");
							}
							else
							{
								System.out.println("Invalid pCode..");
							}
						}
					
							break;
				case 3:
							System.out.println("Delete Operation...");
							System.out.println("Enter the pcode:");
							pCode = sc.nextLine();
							ps = con.prepareStatement(DISPLAY);
							ps.setString(1,pCode);
							rs=ps.executeQuery();
							if(rs.next())
							{
								System.out.println("\npCode:"+rs.getString(1)+"\npName:"+rs.getString(2)+"\n price:"+rs.getFloat(3)+"\nQty:"+rs.getInt(4));
								PreparedStatement ps1 = con.prepareStatement(DELETE);
								System.out.println("Enter the pcode do you want to delete:");
								ps1.setString(1,pCode);
								int k= ps1.executeUpdate();
								if(k>0)
								{
									System.out.println("product has been deleted...");
								}
								else
								{
									System.out.println("Invalid pcode...");
								}
								
							}
					break;
				case 4:
							System.out.println("Display operation...");
							ps = con.prepareStatement(DISPLAY);
							System.out.println("Enter the Product Code..");
							pCode = sc.next();
							ps.setString(1, pCode);
							rs = ps.executeQuery();
							if(rs.next())
							{
								System.out.println("pcode:"+rs.getString(1)+"\npName:"+rs.getString(2)+"\npPrice:"+rs.getLong(3)+"\npQty:"+rs.getInt(4));
							}
					break;
				case 5:
					System.exit(0);
		}
		}
		
	}
}
