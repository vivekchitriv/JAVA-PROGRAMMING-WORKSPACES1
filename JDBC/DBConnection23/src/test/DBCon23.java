package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBCon23 {
	private static final String INSERTBANK25 = "INSERT INTO BANK25 VALUES(4555855,'naresh',10000,'current')";
	private static final String INSERTPRODUCT25 = "INSERT INTO PRODUCT25 VALUES('Z1455','BAGS',45522.25,48)";
	public static void main(String[] args) 
	{
		try {
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		Statement stm = con.createStatement();
		stm.addBatch(INSERTBANK25);
		stm.addBatch(INSERTPRODUCT25);
		int k[] = stm.executeBatch();
		for (int i=0; i<k.length;i++)
		{
			System.out.println("Executed Successfully....");
		}
		con.close();
		sc.close();
		stm.close();
		}catch(ClassNotFoundException | SQLException obj)
		{
			obj.printStackTrace();
		}
	}
}
