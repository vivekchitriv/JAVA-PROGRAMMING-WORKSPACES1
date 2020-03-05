package com.coderswave.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	private static Connection con;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		public static Connection getConnection() {
			return con;
		}
}
