package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class DBCon13 {

	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{	Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		CallableStatement cs = con.prepareCall("{call createAccount25(?,?,?,?,?,?)}");
		System.out.println("Enter the Account Number::");
		cs.setLong(1,Long.parseLong(sc.nextLine()));
		System.out.println("Enter the Customer Name::");
		cs.setString(2, sc.nextLine());
		System.out.println("Enter the balance::");
		cs.setFloat(3,Float.parseFloat(sc.nextLine()));
		System.out.println("Enter the account Type::");
		cs.setString(4, sc.nextLine());
		System.out.println("Enter the adddress::");
		cs.setString(5, sc.nextLine());
		System.out.println("Enter the phone number::");
		cs.setLong(6, Long.parseLong(sc.nextLine()));
		
		cs.execute();
		System.out.println("procedure executed successfully...");
		
		sc.close();
		con.close();
	}
}
