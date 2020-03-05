package test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DBCon20 {
		public static void main(String[] args) throws ClassNotFoundException,SQLException,IOException
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the Fpath & fname:(source)");
			File f = new File(s.nextLine());
			if(f.exists())
			{
				FileReader fr = new FileReader(f);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
				PreparedStatement ps = con.prepareStatement("insert into CStore25 values(?,?)");
				System.out.println("Enter the id:");
				ps.setString(1,s.nextLine());
				ps.setCharacterStream(2, fr,(int)f.length());
				int k = ps.executeUpdate();
				if(k>0)
				{
					System.out.println("file inserted successfull...");
				}
				else
				{
					System.out.println("failed...");
				}
			}
		}
}
