package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
public class DBCon17 {
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "916776");
			Scanner s = new Scanner(System.in);
			PreparedStatement ps = con.prepareStatement("select * from bank25 where accno=?");
			System.out.println("Enter the account Number:");
			Long accNo=Long.parseLong(s.nextLine());
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				CallableStatement cs = con.prepareCall("{?=call getBalance25(?)}");
				
				//con.prepareCall("{?= call myfunction(?,?)}");
				cs.registerOutParameter(1, Types.FLOAT);
				cs.setLong(2, accNo);
				
				cs.execute();
				System.out.println("Account no::"+accNo);
				System.out.println("Balance::"+cs.getFloat(1));
			}
			else
			{
				System.out.println("Invalid account number:");
			}
			
			con.close();
			s.close();
		}catch(ClassNotFoundException | SQLException ob)
		{
			ob.printStackTrace();
		}
		
		
	}
	
	
	
}
