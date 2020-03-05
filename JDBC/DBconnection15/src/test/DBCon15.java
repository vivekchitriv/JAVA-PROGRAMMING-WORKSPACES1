	package test;
	import java.sql.*;
	import java.util.*;
	public class DBCon15
	{
		public static void main(String args[])throws SQLException,ClassNotFoundException
		{
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
			CallableStatement cs = con.prepareCall("{call empdata25(?,?,?,?,?,?,?)}");
			System.out.println("Enter the Emp id::");
			cs.setString(1,sc.nextLine());
			System.out.println("Enter the Emp Name::");
			cs.setString(2,sc.nextLine());
			System.out.println("Enter the Emp Designation::");
			cs.setString(3,sc.nextLine());
			System.out.println("Enter the salary::");
			cs.setFloat(4,Float.parseFloat(sc.nextLine()));
			System.out.println("Enter the Sname::");
			cs.setString(5,sc.nextLine());
			System.out.println("Enter the city::");
			cs.setString(6,sc.nextLine());
			System.out.println("Enter the Pincode::");
			cs.setInt(7,Integer.parseInt(sc.nextLine()));
			cs.execute();
			System.out.println("Emp DATA has been Successfully inserted::");
			
			con.close();
			sc.close();
		}
		
	}	
