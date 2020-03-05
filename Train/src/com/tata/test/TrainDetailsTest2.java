package com.tata.test;

import java.sql.SQLException;
import java.util.List;

import com.tata.dao.TrainDao;

public class TrainDetailsTest2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TrainDao dao = new TrainDao();
		List list = null;
		
		
		list = dao.getAllTrainDetails();
		System.out.println(list.hashCode());
		list.forEach((bo->{
			
			System.out.println(bo);
			
		}));
	}
}
