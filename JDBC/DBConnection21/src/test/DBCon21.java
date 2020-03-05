package test;
import java.io.*;
import java.util.*;
import java.sql.*;
public class DBCon21
{
	public static void main(String args[]) throws ClassNotFoundException,SQLException,IOException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		PreparedStatement ps = con.prepareStatement("select * from CStore25 where id = ?");
		System.out.println("Enetr the id:");
		ps.setString(1, sc.nextLine());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();
			System.out.println("Enter the Fpath & fname(Destination)");
			File f = new File(sc.nextLine());
			FileWriter fw = new FileWriter(f);
			int ch;
			while((ch=r.read())!=-1)
			{
				fw.write(ch);
			}
			fw.close();
			System.out.println("File Retrived Successfully...");
			con.close();
		}
		else
		{
			System.out.println("Invalid id..");
		}
	}
}
