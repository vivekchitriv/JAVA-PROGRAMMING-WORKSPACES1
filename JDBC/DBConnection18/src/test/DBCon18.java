package test;
import java.util.*;
import java.sql.*;
import java.io.*;
public class DBCon18 {
		public static void main(String args[])
		{
		try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the FilePath and File Name(source)");
				File f = new File(sc.nextLine());
				if(f.exists())
				{
					FileInputStream fis = new FileInputStream(f);
					System.out.println("Enter the id:");
					String id = sc.nextLine();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
					PreparedStatement ps = con.prepareStatement("insert into BStore25 values(?,?)");
					ps.setString(1, id);
					ps.setBinaryStream(2, fis,(int)f.length());
					int k = ps.executeUpdate();
					if(k>0)
					{
						System.out.println("File Upload successfully...");
					}
					
					else
					{
						System.out.println("Failed...");
					}
					con.close();
					sc.close();
					fis.close();
					ps.close();
				}
				
				
				
			
			}
		catch(ClassNotFoundException | SQLException | IOException obj)
			{
				obj.printStackTrace();
			}
		}
}
