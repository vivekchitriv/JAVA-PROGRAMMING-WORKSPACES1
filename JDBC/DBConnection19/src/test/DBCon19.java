package test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class DBCon19 {
	public static void main(String args[])
	{
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		String id = sc.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		PreparedStatement ps = con.prepareStatement("select * from BStore25 where id=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			Blob b = rs.getBlob(2);
			byte by[] = b.getBytes(1, (int) b.length());
			System.out.println("Enter PPath and PName(Destination)");
			File f = new File(sc.nextLine());
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(by);
			System.out.println("File Download successfully...");
			fos.close();
		}
		else
		{
			System.out.println("failed to download...");
		}
		}catch(ClassNotFoundException | SQLException | IOException obj)
		{
			obj.printStackTrace();
		}
		
	}
}
