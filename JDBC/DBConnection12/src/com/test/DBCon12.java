package com.test;
import java.util.*;
import java.sql.*;
public class DBCon12
{
	private static final String DISPLAY = "SELECT * FROM PRODUCT25 WHERE PCODE=?";
	private static final String DELETE = "DELETE FROM PRODUCT25 WHERE PCODE=?";
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		System.out.println("Enter the pcode:");
		String pCode = sc.nextLine();
		PreparedStatement ps = con.prepareStatement(DISPLAY);
		ps.setString(1,pCode);
		ResultSet rs=ps.executeQuery();
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
	}
}