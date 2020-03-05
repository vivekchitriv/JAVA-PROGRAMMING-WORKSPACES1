package com.tata.bo;

public class TrainBo {
	private int trainNumber;
	private String name;
	private String source;
	private String destination;
	private float fare;
	
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "TrainBo [trainNumber=" + trainNumber + ", name=" + name + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + "]";
	}
	
	
	
}
