package test;
import java.util.*;
import java.sql.*;
public class DBCon24 {
	
	private static final String INSERTPRODUCT25 = "INSERT INTO PRODUCT25 VALUES(?,?,?,?)"; 
	public static void main(String args[])
	{
		try
		{	Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
			PreparedStatement ps = con.prepareStatement(INSERTPRODUCT25);
					System.out.println("Enter the Product Code::");
					ps.setString(1,sc.nextLine());
					System.out.println("Enter the PName::");
					ps.setString(2, sc.nextLine());
					System.out.println("Enter the Price::");
					ps.setFloat(3,Float.parseFloat(sc.nextLine()));
					System.out.println("Enter the Qty.");
					ps.setInt(4,Integer.parseInt(sc.nextLine()));
					ps.addBatch();
			int k[] = ps.executeBatch();
				for (int i=0;i<k.length;i++)
			{
				
				System.out.println("exceuted Successfully");
			}
				con.close();
				sc.close();
				ps.close();
		}
		catch(ClassNotFoundException | SQLException obj)
		{
			obj.printStackTrace();
		}
	}
}
