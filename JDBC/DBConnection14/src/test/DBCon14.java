package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class DBCon14 {
	public static void main(String[] args)throws ClassNotFoundException,SQLException {
	Scanner s = new Scanner(System.in);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
	CallableStatement cs =con.prepareCall("{call userdata25(?,?,?,?,?,?,?,?)}");
	System.out.println("Enter the user name:");
	cs.setString(1,s.nextLine());
	System.out.println("Enter the password:");
	cs.setString(2, s.nextLine());
	System.out.println("Enter the First name:");
	cs.setString(3, s.nextLine());
	System.out.println("Enter the last name:");
	cs.setString(4, s.nextLine());
	System.out.println("Enter the age:");
	cs.setInt(5, Integer.parseInt(s.nextLine()));
	System.out.println("Enter the Address:");
	cs.setString(6, s.nextLine());
	System.out.println("Enter the phone No:");
	cs.setLong(7, Long.parseLong(s.nextLine()));
	System.out.println("Enter the email:");
	cs.setString(8, s.nextLine());
	cs.execute();
	System.out.println("User Data has been Inserted Successfully...");
	con.close();
	s.close();
	}
}
