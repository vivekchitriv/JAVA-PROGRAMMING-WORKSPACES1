package test;
import java.sql.*;
import java.util.*;
public class DBCon16 {
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the UserName:");
		String uName = s.nextLine();
		System.out.println("Enter the password:");
		String pWord = s.nextLine();
		PreparedStatement ps = con.prepareStatement("select * from UserDetails25 where uname=? and pword=?");
		ps.setString(1, uName);
		ps.setString(2, pWord);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			CallableStatement cs = con.prepareCall("{call fetchUserData25(?,?,?,?,?,?,?,?)}");
			cs.setString(1,uName);
			cs.setString(2, pWord);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7,Types.BIGINT);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();
			
			System.out.println("First Name:"+rs.getString(3));//
			System.out.println("Last Name:"+rs.getString(4));//
			System.out.println("Age:"+rs.getInt(5));
			System.out.println("Address:"+cs.getString(6));
			System.out.println("Phone number:"+cs.getLong(7));
			System.out.println("Email ID:"+cs.getString(8));
		}
		else
		{
			System.out.println("Invalid UserName and Password::");
		}
		con.close();
		s.close();
		
	}
}
