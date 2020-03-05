package com.tata.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.tata.bo.TrainBo;
import com.tata.dao.TrainDao;

public class TrainDetailsTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		TrainBo bo = new TrainBo();
		TrainDao dao = new TrainDao();
		String output = null;
		
		System.out.println("Train Number::");
		bo.setTrainNumber(sc.nextInt());
		System.out.println("Train Name::");
		bo.setName(sc.next());
		System.out.println("Source::");
		bo.setSource(sc.next());
		System.out.println("Destination::");
		bo.setDestination(sc.next());
		System.out.println("Fare::");
		bo.setFare(sc.nextFloat());
		
		
		output = dao.insertTarinDetails(bo);
		System.out.println(output);
		
		sc.close();
		
		
	}
}
