package com.tata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tata.bo.TrainBo;

public class TrainDao {
	public String insertTarinDetails(TrainBo bo) throws ClassNotFoundException, SQLException {
		String result = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		PreparedStatement ps = con.prepareStatement("insert into train values(seq_train.nextval,?,?,?,?,?)");
		ps.setInt(1, bo.getTrainNumber());
		ps.setString(2, bo.getName());
		ps.setString(3, bo.getSource());
		ps.setString(4, bo.getDestination());
		ps.setFloat(5, bo.getFare());
		
		int k = ps.executeUpdate();
		
		if(k>0)
			result="Data Inserted";
		else
			result = "Failed";
		
		return result;		
	}
	
	
	public List getAllTrainDetails() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		PreparedStatement ps = con.prepareStatement("select * from train");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList<TrainBo>();
		
		while(rs.next()) {
			TrainBo bo = new TrainBo();
			
			bo.setTrainNumber(rs.getInt(2));
			bo.setName(rs.getString(3));
			bo.setSource(rs.getString(4));
			bo.setDestination(rs.getString(6));
			bo.setFare(rs.getFloat(6));
			
			list.add(bo);
			
		}
		
		return list;
		
	}
}
