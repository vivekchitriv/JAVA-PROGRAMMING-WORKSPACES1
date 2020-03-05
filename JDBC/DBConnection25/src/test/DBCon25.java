package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class DBCon25 {
	private static  String FETCHBANKDATA25 = "SELECT * FROM BANK25 WHERE ACCNO=?";
	private static  String UPDATEBANKDATA25 = "UPDATE BANK25 SET BAL = BAL+? where ACCNO=?";
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
			PreparedStatement ps = con.prepareStatement(FETCHBANKDATA25);
			System.out.println("Enter the acccountNumber:(SOURCE)");
			long sAccNo = Long.parseLong(sc.nextLine());
			ps.setLong(1, sAccNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				float bal = rs.getFloat(3);
				System.out.println("Enter the AccountNumber:(Destination)");
				long dAccNo = Long.parseLong(sc.nextLine());
				ps.setLong(1, dAccNo);
				ResultSet rs1 = ps.executeQuery();
				if(rs1.next())
				{
					System.out.println("Enter the amt to be transfer::");
					int amt = Integer.parseInt(sc.nextLine());
					if(amt<=bal)
					{
						con.setAutoCommit(false);
						Savepoint s = con.setSavepoint();
						PreparedStatement ps1 = con.prepareStatement(UPDATEBANKDATA25);
						ps1.setFloat(1, -amt);
						ps1.setLong(2, sAccNo);
						
						int i = ps1.executeUpdate();
						
						ps1.setFloat(1,amt);
						ps1.setLong(2, dAccNo);
						int j = ps1.executeUpdate();
						if(i==1 && j==1)
						{
							con.commit();
							System.out.println("Transaction successfully....");
						}
						else
						{
							System.out.println(" transcation..failed...");
							con.rollback(s);
						}
						
					}
					else
					{
						System.out.println("Insufficient Fund....");
					}
				}
				else
				{
					System.out.println("invalid Acc no...");
				}
			}
			else
			{
				System.out.println("Invalid Acc no...");
			}
			con.close();
			sc.close();
		}catch(ClassNotFoundException | SQLException obj)
		{
			obj.printStackTrace();
		}
	}
}
