package com.test.rowset;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DRowSet1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();
		jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		jrs.setUsername("system");
		jrs.setPassword("916776");
		jrs.setCommand("select * from product25");
		jrs.execute();
		System.out.println("==dis normal==");
		while(jrs.next())
		{
			System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getInt(4));
		}//end of while
		System.out.println("==dis in reverse===");
		jrs.afterLast();
		while(jrs.previous())
		{
			System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getInt(4));
		}
	}
}
