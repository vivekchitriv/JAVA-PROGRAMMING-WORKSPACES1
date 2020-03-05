package com.test.connectionpolling;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class ConnectionPoolManager
{
			String databaseUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "system";
			String password = "916776";
			Vector pool = new Vector();
			public ConnectionPoolManager()
			{
				initialize();
			}
			private void initialize()
			{
				initializeConnectionPool();
			}
			private void initializeConnectionPool()
			{
				while(!chackIfConnectionPoolIsFull())
				{
					System.out.println("Connection Pool is Not Full..");
					pool.addElement(createNewConnectionFormPool());
				}
				
				System.out.println("Connection pool is full");
			}
			private synchronized boolean chackIfConnectionPoolIsFull()
			{
				final int MAX_POOL_SIZE=5;
				if(pool.size()<MAX_POOL_SIZE)
				{
					return false;
				}
				return true;
			}
			//creating a connection
			private Connection createNewConnectionFormPool()  
			{
				Connection con = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
					System.out.println("Connection:"+con);
				}
				catch(SQLException sqle)
				{
					
					System.out.println("SQLException"+sqle);
					return null;
				}
				catch(ClassNotFoundException cnfe)
				{
					System.out.println("ClassNotFoundException :"+cnfe);
					return null;
				}
				return con;
			}
				public synchronized Connection getConnectionFormPool()
				{
					Connection con = null;
					if(pool.size()>0)
					{
						con = (Connection)pool.firstElement();
						pool.removeElementAt(0);
					}
					return null;
				}
				@SuppressWarnings("Unchecked")
				public synchronized void returnConnectionToPool(Connection con)
				{
					pool.addElement(con);
				}
				public static void main(String[] args)throws SQLException
				{
					ConnectionPoolManager cpm = new ConnectionPoolManager();
					Connection con = cpm.getConnectionFormPool();
					PreparedStatement ps = con.prepareStatement("select * from product23");
					System.out.println("Dis Using con:"+con);
					System.out.println("size of Connection Pool"+cpm.pool.size());
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
					}
					cpm.returnConnectionToPool(con);
					System.out.println("size of Connection pool:"+cpm.pool.size());
				}
			
	
}
